/**
 * 
 */
package com.loneleh.game.mining;


/**
 * Method.java
 * 
 * @author Loneleh
 */
public enum MiningMethodType
{
	EXPERIENCE("Experience"),
	PROFIT("Profit");
	
	private final String name;
	
	
	private MiningMethodType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
