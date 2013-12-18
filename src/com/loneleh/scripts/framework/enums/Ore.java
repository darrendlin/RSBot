package com.loneleh.scripts.framework.enums;

public enum Ore
{
	CLAY("Clay", 1, 5, false, true),
	RUNE_ESSENCE("Rune Essense", 1, 5, false, true),
	COPPER("Copper ore", 1, 17.5, false, true),
	TIN("Tin ore", 1, 17.5, false, true),
	LIMESTONE("Limestone", 10, 26.5, true, false),
	BLURITE("Blurite ore", 10, 17.5, false, false),
	IRON("Iron ore", 15, 35, false, true),
	ELEMENTAL("Elemental ore", 20, 0, true, false),
	DAEYALT("Daeyalt ore", 20, 17.5, true, false),
	SILVER("Silver ore", 20, 40, false, true),
	PURE_ESSENCE("Pure Essence", 30, 5, true, false),
	COAL("Coal", 30, 50, false, true),
	SANDSTONE1kg("Sandstone (1kg)", 35, 30, true, false),
	SANDSTONE2kg("Sandstone (2kg)", 35, 40, true, false),
	SANDSTONE5kg("Sandstone (5kg)", 35, 50, true, false),
	SANDSTONE10kg("Sandstone (10kg)", 35, 60, true, false),
	UNCUT_OPAL("Uncut opal", 0, 65, true, false),
	UNCUT_JADE("Uncut jade", 0, 65, true, false),
	UNCUT_RED_TOPAZ("Uncut red topaz", 0, 65, true, false),
	UNCUT_SAPPHIRE("Uncut sapphire", 0, 65, false, false),
	UNCUT_EMERALD("Uncut emerald", 0, 65, false, false),
	UNCUT_RUBY("Uncut ruby", 0, 65, false, false),
	UNCUT_DIAMOND("Uncut diamond", 0, 65, false, false),
	GOLD("Gold ore", 40, 65, false, true),
	PERFECT_GOLD_ORE("\'Perfect\' Gold ore", 40, 0, true, false),
	GRANITE500g("Granite (500g)", 45, 50, true, false),
	GRANITE2kg("Granite (2kg)", 45, 60, true, false),
	GRANITE5kg("Granite (5kg)", 45, 75, true, false),
	RUBIUM("Rubium", 46, 17.5, true, false),
	MITHRIL("Mithril ore", 55, 80, false, true),
	LUNAR("Lunar ore", 60, 0, true, false),
	ADAMANTITE("Adamantite ore", 70, 95, false, true),
	LIVING_MINTERALS("Living minerals", 73, 25, true, false),
	BANE_ORE("Bane ore", 77, 90, true, false),
	CONCENTRATED_COAL_ROCKS("Copper", 77, 50, true, false),
	CONCENTRATED_GOLD_ROCKS("Copper", 80, 65, true, false),
	RED_SANDSTONE("Red sandstone", 81, 70, true, false),
	RUNITE("Runite ore", 85, 125, false, true);
	
	private final String name;
	private int price;
	
	private final int miningLevel; // minimum level; used to also sort out ores a player can't mine
	
	private final double experience; // exp gained (not counting bonuses)
	
	private final boolean isMember; // option of easily filter out if is member or f2p
	private final boolean isAvailable; // show up in the gui or not
	
	Ore(String name, int level, double exp, boolean isMember, boolean isAvailable)
	{
		this.name = name;
		
		this.miningLevel = level;
		
		this.experience = exp;
		
		this.isMember = isMember;
		this.isAvailable = isAvailable;
	}
	
	public final String getName() { return name; }
	public final int getPrice() { return price; }
	public final int getMiningLevel() { return miningLevel; }
	public final double getExperience() { return experience; }
	public final boolean isMember() { return isMember; }
	public final boolean isAvailable() { return isAvailable; }
}
