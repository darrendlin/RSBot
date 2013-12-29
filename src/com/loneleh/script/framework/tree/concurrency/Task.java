package com.loneleh.script.framework.tree.concurrency;

import com.loneleh.script.LonelehMining;
import com.loneleh.script.framework.LonelehContext;
import com.loneleh.script.framework.tree.Node;

/**
 * Task.java
 * A task is a concurrent Node that can be run simultaneous to other threads.
 * 
 * @see Node
 * @author Loneleh
 */
public abstract class Task extends Node implements Runnable
{
	
	public Task(final LonelehContext ctx, final LonelehMining lm)
	{
		super(ctx, lm);
	}
	
	@Override
	public boolean validate() {
		return true;
	}
	
	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		if (validate())
			execute();
	}
}
