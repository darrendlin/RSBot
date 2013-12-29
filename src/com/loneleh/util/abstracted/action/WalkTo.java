/**
 * 
 */
package com.loneleh.util.abstracted.action;

import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.TilePath;

import com.loneleh.script.LonelehMining;
import com.loneleh.script.framework.LonelehContext;
import com.loneleh.script.framework.tree.Node;

/**
 * WalkTo.java
 * Meant to be used as anonymous inner classes.
 * 
 * @author Loneleh
 */
public class WalkTo extends Node
{
	protected TilePath path;
	protected Area destinationArea;
	
	protected String name;
	
	/**
	 * @param ctx the method context
	 * @param lm the main script
	 */
	public WalkTo(LonelehContext ctx, LonelehMining lm, String name, TilePath tilePath, Area destination)
	{
		super(ctx, lm);
		this.name = name;
		this.path = tilePath;
		this.destinationArea = destination;
	}

	/**
	 * Walk when you're not in the area - this is the most basic requirement
	 * @see com.loneleh.script.framework.tree.Node#validate()
	 */
	@Override
	public boolean validate() {
		return !destinationArea.contains(ctx.players.local().getLocation());
	}

	/**
	 * Walk
	 * @see com.loneleh.script.framework.tree.Node#execute()
	 */
	@Override
	public void execute() {
		lm.setStatus("Walking to " + name);
		path.traverse();
	}
	
	public String getName() {
		return name;
	}

	/**
	 * @see com.loneleh.util.abstracted.Executable#delay()
	 */
	@Override
	public int delay() {
		return 100;
	}
	
}
