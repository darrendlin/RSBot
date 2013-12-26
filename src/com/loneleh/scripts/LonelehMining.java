package com.loneleh.scripts;

import java.awt.Graphics;

import javax.swing.SwingUtilities;

import org.powerbot.event.MessageEvent;
import org.powerbot.event.MessageListener;
import org.powerbot.event.PaintListener;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.methods.Environment;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Random;

import com.loneleh.scripts.framework.LonelehContext;
import com.loneleh.util.Time;
import com.loneleh.util.display.gui.LonelehMiningWindow;


@Manifest(name = "LonelehMining", version = 3.0, description = "Mines the stuff you want ;) - start after you've logged in", topic = 0, hidden = true)

public class LonelehMining extends PollingScript implements MessageListener, PaintListener
{
	private LonelehMiningWindow window;
	
	public LonelehContext ctx;
	
	public LonelehMining()
	{
		this.ctx = new LonelehContext(super.ctx);
	}
	
	@Override
	public void start()
	{
		log.info("Welcome to " + getName() + ", " + Environment.getDisplayName());
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				try {
					log.info("Loading window...");
					window = new LonelehMiningWindow(LonelehMining.this);
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
	public void suspend()
	{
		log.info(getName() + " paused - run time: " + Time.format(getRuntime()));
	}
	
	@Override
	public void resume()
	{
		log.info(getName() + " resumed.");
	}
	
	@Override
	public void stop()
	{
		log.info("Thanks for using " + getName() + "; hope to see you again - run time: " + Time.format(getRuntime()));
		super.stop();
	    ctx.shutdownExecutor();
	}
	
	@Override
    public void setContext(MethodContext mc) {
        this.ctx.init(mc);
    }
	
	@Override
	public int poll()
	{
		return Random.nextInt(500, 600);
	}

	@Override
	public void repaint(Graphics g)
	{
		
	}

	@Override
	public void messaged(MessageEvent e)
	{
		
	}
}
