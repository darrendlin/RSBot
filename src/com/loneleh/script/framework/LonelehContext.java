package com.loneleh.script.framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.powerbot.script.methods.MethodContext;

import com.loneleh.script.methods.LonelehBackpack;


public class LonelehContext extends MethodContext
{
	private final ExecutorService executor;
	private boolean running;
	
	/*
	 * Add public MyBits (extending Contextable) here
	 * Usage: ctx.myBits.newFunctions()...
	 */
	public LonelehBackpack backpack;
	
	public LonelehContext(MethodContext ctx)
	{
        super(ctx.getBot());
        init(ctx);
        this.running = true;
        this.executor = Executors.newCachedThreadPool();
    }
	
	@Override
    public void init(MethodContext ctx) {
        super.init(ctx);
        
        /*
         * Initialize myBits = new MyBit(this)
         */
        this.backpack = new LonelehBackpack(ctx);
    }
	
	public boolean isRunning() { return running; }
	public ExecutorService getExecutor() { return executor; }
	
	public void shutdownExecutor()
	{
	    this.running = false;
	    executor.shutdown();
	}
}
