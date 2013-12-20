package com.loneleh.scripts.framework;

import java.util.logging.Logger;

import org.powerbot.script.methods.MethodProvider;


public class Contextable extends MethodProvider
{
	protected final LonelehContext ctx;
	protected Logger log = Logger.getLogger(this.getClass().getSimpleName());
	
	public Contextable(final LonelehContext ctx)
	{
		super(ctx);
		this.ctx = ctx;
	}
}
