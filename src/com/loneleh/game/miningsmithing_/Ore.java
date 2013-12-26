package com.loneleh.game.miningsmithing_;

import java.net.URL;

import org.powerbot.script.util.GeItem;

import com.loneleh.util.display.Displayable;
@Deprecated
public enum Ore implements Displayable
{
	CLAY(434, false),
	RUNE_ESSENCE(1436, false),
	COPPER(436, true),
	TIN(438, true),
	LIMESTONE(3211, false),
	BLURITE(668, false),
	IRON(440, true),
	ELEMENTAL(2892, false),
	DAEYALT(9632, false),
	SILVER(442, true),
	PURE_ESSENCE(7936, false),
	COAL(453, true),
	SANDSTONE1kg(6971, false),
	SANDSTONE2kg(6973, false),
	SANDSTONE5kg(6975, false),
	SANDSTONE10kg(6977, false),
	UNCUT_OPAL(1625, false),
	UNCUT_JADE(1627, false),
	UNCUT_RED_TOPAZ(1629, false),
	UNCUT_SAPPHIRE(1623, false),
	UNCUT_EMERALD(1621, false),
	UNCUT_RUBY(1619, false),
	UNCUT_DIAMOND(1617, false),
	GOLD(444, true),
	PERFECT_GOLD_ORE(446, false),
	GRANITE500g(6979, false),
	GRANITE2kg(6981, false),
	GRANITE5kg(6983, false),
	RUBIUM(12630, false),
	MITHRIL(447, true),
	LUNAR(9076, false),
	ADAMANTITE(449, true),
	LIVING_MINERALS(15263, false),
	BANE_ORE(21778, false),
	RED_SANDSTONE(23194, false),
	RUNITE(451, true);
	
	private final GeItem item;
	
	private final boolean isVisible; // show up in the gui or not
	
	Ore(int id, boolean visible)
	{
		System.out.println("ore id: " + id);
		this.item = GeItem.getProfile(id);
		System.out.println("ore name: " + item.getName());
		this.isVisible = visible;
	}
	
	public String getName() { return item.getName(); }
	public int getId() { return item.getId(); }
	public int getCurrentPrice() { return item.getPrice(GeItem.PriceType.CURRENT).getPrice(); }
	public URL getIconUrl() { return item.getIcon(); }
	public boolean isMember() { return item.isMembers(); }
	public boolean isVisible() { return isVisible; }
}
