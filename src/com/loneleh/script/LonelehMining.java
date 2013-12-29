package com.loneleh.script;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.SwingUtilities;

import org.powerbot.event.MessageEvent;
import org.powerbot.event.MessageListener;
import org.powerbot.event.PaintListener;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.methods.Environment;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Random;

import com.loneleh.game.mining.MineType;
import com.loneleh.game.mining.MineralType;
import com.loneleh.game.mining.MiningMethodType;
import com.loneleh.game.mining.RockType;
import com.loneleh.game.mining.abstracted.Minable;
import com.loneleh.script.framework.LonelehContext;
import com.loneleh.script.framework.tree.Node;
import com.loneleh.script.framework.tree.concurrency.LoopTask;
import com.loneleh.util.abstracted.action.Deposit;
import com.loneleh.util.abstracted.action.Mine;
import com.loneleh.util.abstracted.action.WalkTo;
import com.loneleh.util.display.gui.LonelehMiningStatsWindow;
import com.loneleh.util.display.gui.LonelehMiningWindow;
import com.loneleh.util.factories.MineralFactory;
import com.loneleh.util.factories.MineTypeFactory;
import com.loneleh.util.factories.MiningMethodTypeFactory;
import com.loneleh.util.factories.RockTypeFactory;
import com.loneleh.util.helper.Time;


@Manifest(name = "LonelehMining",
version = 3.0, 
description = "Mines the stuff you want ;) - start after you've logged in", 
topic = 0, 
hidden = true)

public class LonelehMining extends PollingScript implements MessageListener, PaintListener
{
	private LonelehMiningWindow window;
	private LonelehMiningStatsWindow statsWindow;
	
	private LonelehContext ctx;

	private volatile boolean started = false;

	private volatile List<Node> nodes = new ArrayList<Node>();
	private volatile ListIterator<Node> nodeIterator;

	public LonelehMining() {
		this.ctx = new LonelehContext(super.ctx);
	}

	/**
	 * Called from LonelehWindow, providing user options and this is where
	 * the Branches/Nodes will be offered and executed
	 */
	public void beginScript(final String method, final String mine, final String[] ores) {

		getController().getExecutor().offer(new Runnable() {
			@Override
			public void run() {
				// initialize the 3 things needed to run the script
				MiningMethodType methodType = MiningMethodTypeFactory.getMiningMethod(method);
				MineType mineType = MineTypeFactory.getMine(mine);
				List<Minable> minables = new ArrayList<Minable>();
				
				List<Integer> rockIdsList = new ArrayList<Integer>();
				for (int i = 0 ; i < ores.length ; i++) {
					Minable m = MineralFactory.getMineral(ores[i]);
					m.setPriority(i);
					minables.add(m);
					for (int id : RockTypeFactory.getRock(m.getMineralType()).getIds()) {
						rockIdsList.add(id);
					}
				}
				int[] rockIds = new int[rockIdsList.size()];
				for (int i = 0 ; i < rockIds.length ; i++)
					rockIds[i] = rockIdsList.get(i);
				
				for (MineralType t : MineralType.values()) {
					if (t.isGem()) {
						minables.add(MineralFactory.getMineral(t.getName()));
					}
				}

				//TODO create nodes and other threads here
				// walk to mine
				nodes.add(new WalkTo(
						ctx, 
						LonelehMining.this, 
						mineType.getName(), 
						ctx.movement.newTilePath(mineType.getTilesToMine()), 
						mineType.getMineArea()));
				// mine
				nodes.add(new Mine(
						ctx,
						LonelehMining.this,
						rockIds));
				
				if (methodType == MiningMethodType.PROFIT) {
					// walk to bank
					nodes.add(new WalkTo(
							ctx, 
							LonelehMining.this, 
							mineType.getName() + " bank", 
							ctx.movement.newTilePath(mineType.getTilesToMine()).reverse(), 
							mineType.getBankArea()));
					// deposit
					nodes.add(new Deposit(
							ctx,
							LonelehMining.this,
							new int[] {}));
				} else if (methodType == MiningMethodType.EXPERIENCE) {
					// drop
					
				}


				nodeIterator = nodes.listIterator();
				
				log.info("Nodes submitted - starting for real now..");
				started = true;
				window.setVisible(false);
				
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							log.info("Loading stats window...");
							statsWindow = new LonelehMiningStatsWindow(LonelehMining.this, ctx);
							statsWindow.setVisible(true);
							log.info("Stats window loaded!");

						} catch (Exception e) {
							log.severe("Failed to load stats window!");
							e.printStackTrace();
						}
					}
				});
				
				// timer for stats window
				ctx.getExecutor().submit(new LoopTask(ctx, LonelehMining.this) {

					@Override
					public boolean validate() {
						return statsWindow != null && statsWindow.isVisible() && !LonelehMining.this.getController().isSuspended();
					}
					
					@Override
					public void execute() {
						statsWindow.setRuntime(Time.format(lm.getRuntime()));
					}

					@Override
					public int delay() {
						return 100;
					}});
			}});
	}

	@Override
	public void start() {
		log.info("Welcome to " + getName() + ", " + Environment.getDisplayName());

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					log.info("Loading window...");
					window = new LonelehMiningWindow(LonelehMining.this, ctx);
					window.setVisible(true);
					log.info("Window loaded!");

				} catch (Exception e) {
					log.severe("Failed to load window!");
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void suspend() {
		statsWindow.setStatus("Script paused");
		log.info(getName() + " paused - run time: " + Time.format(getRuntime()));
	}

	@Override
	public void resume() {
		log.info(getName() + " resumed.");
	}

	@Override
	public void stop() {
		statsWindow.setStatus("Script stopped");
		log.info("Thanks for using " + getName() + "; hope to see you again - run time: " + Time.format(getRuntime()));
		super.stop();
		ctx.shutdownExecutor();
	}

	@Override
	public void setContext(MethodContext mc) {
		this.ctx.init(mc);
	}

	@Override
	public int poll() {
		if (started) {
			if (nodeIterator.hasNext()) {
				Node n = nodeIterator.next();
				if (n.validate()) {
					n.execute();
					return n.delay();
				}
			} else {
				// reset to first
				nodeIterator = nodes.listIterator();
			}
		}

		return Random.nextInt(500, 600);
	}

	@Override
	public void repaint(Graphics g) {

	}

	@Override
	public void messaged(MessageEvent e) {

	}
	
	public void setStatus(String status) {
		statsWindow.setStatus(status);
	}
}
