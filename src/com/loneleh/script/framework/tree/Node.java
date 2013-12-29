/**
 * 
 */
package com.loneleh.script.framework.tree;

import com.loneleh.script.LonelehMining;
import com.loneleh.script.framework.Contextable;
import com.loneleh.script.framework.LonelehContext;
import com.loneleh.util.abstracted.Executable;

/**
 * Node.java
 * 
 * @author Loneleh
 */
public abstract class Node extends Contextable implements Executable
{
	protected final LonelehMining lm;
	
	/**
	 * @param ctx the method context
	 * @param lm the main script
	 */
	public Node(final LonelehContext ctx, final LonelehMining lm)
	{
		super(ctx);
		this.lm = lm;
	}
}
