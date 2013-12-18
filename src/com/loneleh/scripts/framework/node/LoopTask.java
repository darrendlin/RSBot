package com.loneleh.scripts.framework.node;

import com.loneleh.scripts.framework.LonelehContext;


public abstract class LoopTask extends Task
{
	private boolean running;
	
	public LoopTask(final LonelehContext ctx)
	{
		super(ctx);
		this.running = true;
	}
	
	public abstract int loop();
	
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
