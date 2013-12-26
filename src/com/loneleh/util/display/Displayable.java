/**
 * 
 */
package com.loneleh.util.display;

/**
 * Displayable.java
 * 
 * @author Loneleh
 */
public interface Displayable
{
	/**
	 * @return name of the element displayed on window
	 */
	public String getName();
	/**
	 * @return true if is to be displayed on window, false otherwise
	 */
	public boolean isVisible();
}
