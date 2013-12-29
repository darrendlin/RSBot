/**
 * 
 */
package com.loneleh.script.methods;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.MethodProvider;

import com.loneleh.script.framework.Contextable;
import com.loneleh.script.framework.LonelehContext;

/**
 * Backpack.java
 * 
 * @author Loneleh
 */
public class LonelehBackpack extends org.powerbot.script.methods.Backpack
{
	/**
	 * @param ctx the method context
	 */
	public LonelehBackpack(MethodContext ctx) {
		super(ctx);
	}

	public boolean isBagEmpty() {
		return this.select().count() == 0;
	}
	
	public boolean isBagFull() {
		return this.select().count() == 28;
	}

}
