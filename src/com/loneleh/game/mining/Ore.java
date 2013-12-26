/**
 * 
 */
package com.loneleh.game.mining;

import com.loneleh.game.mining.abstracted.Minable;


/**
 * Ore.java
 * 
 * @author Loneleh
 */
public class Ore extends Minable
{
	/**
	 * @param type String representation of <code>MineralType</code>
	 */
	public Ore(MineralType type) {
		super(type);
	}
	
	public boolean isGem() {
		return false;
	}
	
}
