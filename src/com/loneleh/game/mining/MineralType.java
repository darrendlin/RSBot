/**
 * 
 */
package com.loneleh.game.mining;

/**
 * MineralType.java
 * 
 * @author Loneleh
 */
public enum MineralType
{
	CLAY(434, "Clay", 5, false),
	TIN(438, "Tin", 17.5, false),
	COPPER(436, "Copper", 17.5, false),
	IRON(440, "Iron", 35, false),
	SILVER(442, "Silver", 40, false),
	COAL(453, "Coal", 50, false),
	GOLD(444, "Gold", 65, false),
	MITHRIL(447, "Mithril", 80, false),
	ADAMANTITE(449, "Adamantite", 95, false),
	RUNITE(451, "Runite", 125, false),
	SAPPHIRE(1623, "Sapphire", 65, true),
	EMERALD(1621, "Emerald", 65, true),
	RUBY(1619, "Ruby", 65, true),
	DIAMOND(1617, "Diamond", 65, true);
	
	private final int id;
	private final String name;
	private final double exp;
	private final boolean isGem;
	
	
	private MineralType(int id, String name, double exp, boolean isGem) {
		this.id = id;
		this.name = name;
		this.exp = exp;
		this.isGem = isGem;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the exp
	 */
	public double getExp() {
		return exp;
	}
	
	public boolean isGem() {
		return isGem;
	}
	
}
