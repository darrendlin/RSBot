package com.loneleh.scripts.framework.concurrency;

import com.loneleh.scripts.framework.LonelehContext;

public abstract class Task extends Contextable implements Runnable
{
	public Task(final LonelehContext ctx)
	{
		super(ctx);
	}
	
	public abstract boolean validate();
	
	public abstract void execute();
}
