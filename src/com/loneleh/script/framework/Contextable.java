package com.loneleh.script.framework;

import org.powerbot.script.methods.MethodProvider;

import com.loneleh.script.LonelehMining;

/**
 * Contextable.java
 * Used for script concurrency/ task/ looptask as well as extending method context functionalities.
 * 
 * @author Loneleh
 */
public class Contextable extends MethodProvider
{
	protected LonelehContext ctx;
	
	public Contextable(LonelehContext ctx)
	{
		super(ctx);
		this.ctx = ctx;
	}
}
