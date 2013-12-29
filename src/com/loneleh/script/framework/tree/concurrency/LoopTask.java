package com.loneleh.script.framework.tree.concurrency;

import com.loneleh.script.LonelehMining;
import com.loneleh.script.framework.LonelehContext;

/**
 * LoopTask.java
 * A LoopTask is a Task that runs in a loop.
 * 
 * @see Task
 * @see Node
 * @author Loneleh
 */
public abstract class LoopTask extends Task
{
	private boolean running;
	
	public LoopTask(final LonelehContext ctx, final LonelehMining lm)
	{
		super(ctx, lm);
		this.running = true;
	}
	
	public int loop() {
		if (validate())
			execute();
		return delay();
	}
	
	@Override
    public void run() {
        while (running && ctx.isRunning()) {
            try {
                final int wait = loop();
                if (wait > 0) {
                	sleep(wait);
                } else {
                    running = false;
                }
            } catch (final Throwable t) {
                t.printStackTrace();
            }
        }
    }

}
