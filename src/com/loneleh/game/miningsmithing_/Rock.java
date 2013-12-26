package com.loneleh.game.miningsmithing_;
@Deprecated
public enum Rock
{
	CLAY("Clay rock", Ore.CLAY, new int[] {}, 1, 5, false), // ??
	RUNE_ESSENCE("Rune Essense", Ore.RUNE_ESSENCE, new int[] {}, 1, 5, false),
	COPPER("Copper ore rocks", Ore.COPPER, new int[] {3229, 3027, 11936, 11938}, 1, 17.5, false),
	TIN("Tin ore rocks", Ore.TIN, new int[] {11933, 3245, 3038}, 1, 17.5, false),
	LIMESTONE("Limestone", Ore.LIMESTONE, new int[] {}, 10, 26.5, true), // ??
	BLURITE("Blurite ore rocks", Ore.BLURITE, new int[] {}, 10, 17.5, false), // ??
	IRON("Iron ore rocks", Ore.IRON, new int[] {37307, 37308, 37309}, 15, 35, false),
	ELEMENTAL("Elemental ore rocks", Ore.ELEMENTAL, new int[] {}, 20, 0, true),
	DAEYALT("Daeyalt ore rocks", Ore.DAEYALT, new int[] {}, 20, 17.5, true),
	SILVER("Silver ore rocks", Ore.SILVER, new int[] {37304, 37305, 37306, 29224, 29225, 29226}, 20, 40, false),
	PURE_ESSENCE("Pure Essence", Ore.PURE_ESSENCE, new int[] {}, 30, 5, true), //?? 
	COAL("Coal rocks", Ore.COAL, new int[] {11930, 11932, 3032, 3233, 5770, 5771, 5772, 32426, 32427, 32428}, 30, 50, false),
	SANDSTONE("Sandstone", Ore.SANDSTONE1kg, new int[] {}, 35, 30, true), // ??
	GOLD("Gold ore rocks", Ore.GOLD, new int[] {37310, 37312}, 40, 65, false),
	PERFECT_GOLD_ORE("\'Perfect\' Gold ore", Ore.PERFECT_GOLD_ORE, new int[] {}, 40, 0, true), // ??
	GRANITE500g("Granite (500g)", Ore.GRANITE500g, new int[] {}, 45, 50, true),
	GRANITE2kg("Granite (2kg)", Ore.GRANITE2kg, new int[] {}, 45, 60, true),
	GRANITE5kg("Granite (5kg)", Ore.GRANITE5kg, new int[] {}, 45, 75, true),
	RUBIUM("Rubium", Ore.RUBIUM, new int[] {}, 46, 17.5, true), // ??
	MITHRIL("Mithril ore rocks", Ore.MITHRIL, new int[] {11942, 11944, 3041, 3280, 5784, 5785, 5786, 32438, 32439, 32440, 32438, 32439, 32440}, 55, 80, false),
	LUNAR("Lunar ore", Ore.LUNAR, new int[] {}, 60, 0, true), // ??
	ADAMANTITE("Adamantite ore rocks", Ore.ADAMANTITE, new int[] {11939, 11941, 3273, 3040, 32435, 32436, 32437}, 70, 95, false),
	LIVING_MINTERALS("Living minerals", Ore.LIVING_MINERALS, new int[] {}, 73, 25, true),
	BANE_ORE("Bane ore", Ore.BANE_ORE, new int[] {}, 77, 90, true), // ?? 
	RED_SANDSTONE("Red sandstone", Ore.RED_SANDSTONE, new int[] {}, 81, 70, true),
	RUNITE("Runite ore rocks", Ore.RUNITE, new int[] {33078, 33079}, 85, 125, false);
	
	private final String name;
	private final Ore ore;
	private final int[] ids;
	
	private final double experience;
	
	private final int miningLevel;
	
	private final boolean isMember;
	
	Rock(String name, Ore ore, int[] ids, int minLevel, double experience, boolean member)
	{
		this.name = name;
		this.ore = ore;
		this.ids = ids;
		
		this.experience = experience;
		
		this.miningLevel = minLevel;
		
		this.isMember = member;
	}
	
	public String getName() { return name; }
	public Ore getOre() { return ore; }
	public int[] getIds() { return ids; }
	public int getMiningLevel() { return miningLevel; }
	public double getExperience() { return experience; }
	public boolean isMember() { return isMember; }
	public boolean isAvailable() { return ids.length > 0; }
}
