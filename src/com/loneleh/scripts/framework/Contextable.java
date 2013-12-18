package com.loneleh.scripts.framework;

import org.powerbot.script.methods.MethodProvider;


public class Contextable extends MethodProvider
{
	protected final LonelehContext ctx;
	
	public Contextable(final LonelehContext ctx)
	{
		super(ctx);
		this.ctx = ctx;
	}
}
