package com.loneleh.scripts.framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.powerbot.script.methods.MethodContext;


public class LonelehContext extends MethodContext
{
	private final ExecutorService executor;
	private boolean running;
	
	public LonelehContext(MethodContext ctx)
	{
        super(ctx.getBot());
        this.running = true;
        this.executor = Executors.newCachedThreadPool();
    }
	
	public boolean isRunning() { return running; }
	public ExecutorService getExecutor() { return executor; }
	
	public void shutdownExecutor()
	{
	    this.running = false;
	    executor.shutdown();
	}
}
