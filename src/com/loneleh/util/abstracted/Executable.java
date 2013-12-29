/**
 * 
 */
package com.loneleh.util.abstracted;

/**
 * Executable.java
 * 
 * @author Loneleh
 */
public interface Executable
{
	/**
	 * @return true if execute() is permitted to be called
	 */
	public abstract boolean validate();
	
	/**
	 * execution of the Branch/Node
	 */
	public abstract void execute();
	
	/**
	 * delay time in milliseconds
	 */
	public abstract int delay();
	
}
