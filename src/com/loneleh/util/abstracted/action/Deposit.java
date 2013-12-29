/**
 * 
 */
package com.loneleh.util.abstracted.action;

import java.util.concurrent.Callable;

import org.powerbot.script.methods.Hud.Window;
import org.powerbot.script.util.Condition;
import org.powerbot.script.wrappers.Item;

import com.loneleh.script.LonelehMining;
import com.loneleh.script.framework.LonelehContext;
import com.loneleh.script.framework.tree.Node;

/**
 * Deposit.java
 * 
 * @author Loneleh
 */
public class Deposit extends Node
{
	protected int[] excludedIds;
	
	/**
	 * @param ctx the method context
	 * @param excluded the array of ids representing items not to be banked
	 */
	public Deposit(LonelehContext ctx, LonelehMining lm, int[] excluded) {
		super(ctx, lm);
		this.excludedIds = excluded;
	}

	/**
	 * @see com.loneleh.script.framework.tree.Node#validate()
	 */
	@Override
	public boolean validate() {
		if (!ctx.hud.isOpen(Window.BACKPACK)) {
			if (!Condition.wait(new Callable<Boolean>() {
				@Override
				public Boolean call() throws Exception {
					return ctx.hud.open(Window.BACKPACK);
				}})) {
				return false;
			}
		}
		if (!ctx.hud.isVisible(Window.BACKPACK)) {
			if (!Condition.wait(new Callable<Boolean>() {
				@Override
				public Boolean call() throws Exception {
					return ctx.hud.view(Window.BACKPACK);
				}})) {
				return false;
			}
		}
		return ctx.backpack.isBagFull();
	}

	/**
	 * @see com.loneleh.script.framework.tree.Node#execute()
	 */
	@Override
	public void execute() {
		lm.setStatus("Depositing ores");
		//TODO "Deposit All"
		lm.log.info("Executing Deposit");
		
		if (ctx.backpack.id(excludedIds).isEmpty()) {
			if (Condition.wait(new Callable<Boolean>() {
				@Override
				public Boolean call() throws Exception {
					return ctx.bank.open();
				}})) {
				ctx.bank.depositInventory();
			}
		} else {
			//for (final Item i : ctx.backpack) {
			Item item;
			while ((item = ctx.backpack.poll()) != ctx.backpack.getNil()) {
				if (!item.isOnScreen()) {
					//i = ctx.backpack.poll();
					final Item i = item;
					Condition.wait(new Callable<Boolean>() {
						@Override
						public Boolean call() throws Exception {
							return ctx.backpack.scroll(i);
						}});
				}
				item.interact("Deposit All");
			}
		}
	}

	/**
	 * @see com.loneleh.util.abstracted.Executable#delay()
	 */
	@Override
	public int delay() {
		return 100;
	}

}
