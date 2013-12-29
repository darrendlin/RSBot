/**
 * 
 */
package com.loneleh.game.mining;


/**
 * Rock.java
 * 
 * @author Loneleh
 */
public enum RockType
{
	CLAY(new int[] {}, "Clay rocks", MineralType.CLAY),
	TIN(new int[] {11933, 3245, 3038}, "Tin ore rocks", MineralType.TIN),
	COPPER(new int[] {3229, 3027, 11936, 11938}, "Copper", MineralType.COPPER),
	IRON(new int[] {37307, 37308, 37309}, "Iron ore rocks", MineralType.IRON),
	SILVER(new int[] {37304, 37305, 37306, 29224, 29225, 29226}, "Silver ore rocks", MineralType.SILVER),
	COAL(new int[] {11930, 11932, 3032, 3233, 5770, 5771, 5772, 32426, 32427, 32428}, "Coal rocks", MineralType.COAL),
	GOLD(new int[] {37310, 37312}, "Gold ore rocks", MineralType.GOLD),
	MITHRIL(new int[] {11942, 11944, 3041, 3280, 5784, 5785, 5786, 32438, 32439, 32440, 32438, 32439, 32440}, "Mithril ore rocks", MineralType.MITHRIL),
	ADAMANTITE(new int[] {11939, 11941, 3273, 3040, 32435, 32436, 32437}, "Adamantite ore rocks", MineralType.ADAMANTITE),
	RUNITE(new int[] {33078, 33079}, "Runite ore rocks", MineralType.RUNITE);
	
	private final String name;
	private final int[] ids;
	private final MineralType mineral;
	
	
	private RockType(int[] ids, String name, MineralType type) {
		this.ids = ids;
		this.name = name;
		this.mineral = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the ids
	 */
	public int[] getIds() {
		return ids;
	}


	/**
	 * @return the type
	 */
	public MineralType getMineral() {
		return mineral;
	}
}
