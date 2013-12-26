package com.loneleh.game.miningsmithing_;
@Deprecated
public enum Pickaxe
{
	DWARVEN_ARMY_AXE("Dwarven army axe", 1, 1, false),
	BRONZE("Bronze pickaxe", 1, 1, false),
	IRON("Iron pickaxe", 1, 10, false),
	STEEL("Steel pickaxe", 6, 20, false),
	MITHRIL("Mithril pickaxe", 21, 30, false),
	ADAMANT("Adamant pickaxe", 31, 40, false),
	RUNE("Rune pickaxe", 41, 50, false),
	DRAGON("Dragon pickaxe", 61, 60, true);
	
	private final String name;
	
	private final int miningLevel, attackLevel;
	
	private final boolean isMember;
	
	Pickaxe(String name, int mLevel, int aLevel, boolean isMember)
	{
		this.name= name;
		
		this.miningLevel = mLevel;
		this.attackLevel = aLevel;
		
		this.isMember = isMember;
	}
	
	public final String getName() { return name; }
	public final int getMiningLevel() { return miningLevel; }
	public final int getAttackLevel() { return attackLevel; }
	public final boolean isMember() { return isMember; }
}
