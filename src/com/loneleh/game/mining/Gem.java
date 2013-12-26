/**
 * 
 */
package com.loneleh.game.mining;

import com.loneleh.game.mining.abstracted.Minable;


/**
 * Gem.java
 * 
 * @author Loneleh
 */
public class Gem extends Minable
{
	/**
	 * @param type String representation of <code>MineralType</code>
	 */
	public Gem(MineralType type) {
		super(type);
		this.exp = 65;
	}
	
	public boolean isGem() {
		return true;
	}

}
