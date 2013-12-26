package com.loneleh.scripts.framework.concurrency;

import org.powerbot.script.methods.MethodProvider;

import com.loneleh.scripts.framework.LonelehContext;

/**
 * Contextable.java
 * Used for script concurrency/ task/ looptask as well as extending method context functionalities.
 * 
 * @author Loneleh
 */
public class Contextable extends MethodProvider
{
	protected final LonelehContext ctx;
	
	public Contextable(final LonelehContext ctx)
	{
		super(ctx);
		this.ctx = ctx;
	}
}
