/**
 * 
 */
package com.loneleh.util.abstracted.action;

import java.util.Comparator;

import org.powerbot.script.wrappers.GameObject;

import com.loneleh.script.LonelehMining;
import com.loneleh.script.framework.LonelehContext;
import com.loneleh.script.framework.tree.Node;
import com.loneleh.util.factories.RockTypeFactory;

/**
 * Mine.java
 * 
 * @author Loneleh
 */
public class Mine extends Node
{
	//protected List<Minable> minables;

	protected int[] rockIds;

	/**
	 * @param ctx the method context
	 * @param lm the main script
	 */
	public Mine(LonelehContext ctx, LonelehMining lm, int[] ids)
	{
		super(ctx, lm);
		this.rockIds = ids;
	}

	/**
	 * @see com.loneleh.util.abstracted.Executable#validate()
	 */
	@Override
	public boolean validate() {
		return !ctx.backpack.isBagFull() && 
				!ctx.objects.select().id(rockIds).within(100.0).isEmpty();
	}

	/**
	 * @see com.loneleh.util.abstracted.Executable#execute()
	 */
	@Override
	public void execute() {
		GameObject o = ctx.objects.id(rockIds).sort(new Comparator<GameObject>() {
			@Override
			public int compare(GameObject o1, GameObject o2) {
				return RockTypeFactory.getRock(o1.getName()).getMineral().getPriority() - RockTypeFactory.getRock(o2.getName()).getMineral().getPriority();
			}}).poll();
		lm.setStatus("Mining " + o.getName());
		o.interact("Mine", o.getName());
	}

	/**
	 * @see com.loneleh.util.abstracted.Executable#delay()
	 */
	@Override
	public int delay() {
		return 50;
	}

}
