/**
 * 
 */
package com.loneleh.game.mining;

import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.Tile;

import com.loneleh.util.display.Displayable;


/**
 * Mine.java
 * 
 * @author Loneleh
 */
public enum MineType implements Displayable
{	
	AL_KHARID(
			"Al Kharid", 
			new RockType[] {
					RockType.TIN,
					RockType.COPPER,
					RockType.IRON, 
					RockType.COAL, 
					RockType.SILVER, 
					RockType.GOLD, 
					RockType.MITHRIL, 
					RockType.ADAMANTITE}, 
					true,
					new Area(
							new Tile(3299, 3318, 0),
							new Tile(3295, 3313, 0),
							new Tile(3292, 3301, 0),
							new Tile(3296, 3288, 0),
							new Tile(3301, 3286, 0),
							new Tile(3308, 3288, 0),
							new Tile(3303, 3297, 0),
							new Tile(3306, 3303, 0),
							new Tile(3304, 3318, 0)),
							new Area(
									new Tile(3272, 3171, 0),
									new Tile(3272, 3163, 0),
									new Tile(3267, 3164, 0),
									new Tile(3268, 3172, 0)),
									new Tile[] {
				new Tile(3271, 3167, 0),
				new Tile(3275, 3167, 0),
				new Tile(3275, 3173, 0),
				new Tile(3277, 3181, 0),
				new Tile(3280, 3186, 0),
				new Tile(3281, 3191, 0),
				new Tile(3281, 3201, 0),
				new Tile(3281, 3211, 0),
				new Tile(3279, 3221, 0),
				new Tile(3280, 3231, 0),
				new Tile(3286, 3239, 0),
				new Tile(3293, 3247, 0),
				new Tile(3295, 3257, 0),
				new Tile(3294, 3267, 0),
				new Tile(3296, 3277, 0),
				new Tile(3301, 3286, 0),
				new Tile(3299, 3296, 0)}),
				BARBARIAN_VILLAGE(
						"Barbarian Village", 
						new RockType[] {
								RockType.TIN,
								RockType.COAL}, 
								true,
								new Area(
										new Tile(3077, 3423, 0),
										new Tile(3077, 3416, 0),
										new Tile(3086, 3416, 0),
										new Tile(3084, 3425, 0)),
										new Area(
												new Tile(3178, 3448, 0),
												new Tile(3178, 3431, 0),
												new Tile(3195, 3431, 0),
												new Tile(3195, 3448, 0)),
												new Tile[] {
							new Tile(3185, 3437, 0),
							new Tile(3179, 3429, 0),
							new Tile(3169, 3428, 0),
							new Tile(3161, 3422, 0),
							new Tile(3151, 3420, 0),
							new Tile(3141, 3421, 0),
							new Tile(3131, 3421, 0),
							new Tile(3121, 3421, 0),
							new Tile(3111, 3421, 0),
							new Tile(3101, 3420, 0),
							new Tile(3091, 3420, 0),
							new Tile(3081, 3423, 0)
						}),
						CRAFTING_GUILD(
								"Crafting Guild", 
								new RockType[] {
										RockType.CLAY, 
										RockType.SILVER, 
										RockType.GOLD},  
										false,
										new Area(
												new Tile(2939, 3292, 0),
												new Tile(2939, 3285, 0),
												new Tile(2937, 3280, 0),
												new Tile(2938, 3276, 0),
												new Tile(2943, 3275, 0),
												new Tile(2944, 3291, 0)
												),
												null,
												null),
												DWARVEN_MINE(
														"Dwarven Mine", 
														new RockType[] {
																RockType.CLAY, 
																RockType.COPPER, 
																RockType.TIN, 
																RockType.IRON, 
																RockType.COAL, 
																RockType.GOLD, 
																RockType.MITHRIL, 
																RockType.ADAMANTITE}, 
																false,
																null,
																null,
																null),
																EDGEVILLE_DUNGEON_MINE(
																		"Edgeville Dungeon Mine", 
																		new RockType[] {
																				RockType.COPPER, 
																				RockType.TIN, 
																				RockType.IRON, 
																				RockType.SILVER, 
																				RockType.COAL, 
																				RockType.MITHRIL, 
																				RockType.ADAMANTITE}, 
																				false,
																				null,
																				null,
																				new Tile[] {}),
																				LUMBRIDGE_SWAMP_EAST(
																						"Lumbridge Swamp (east)", 
																						new RockType[] {
																								RockType.COPPER,
																								RockType.TIN}, 
																								true,
																								new Area(
																										new Tile(3227, 3154, 0),
																										new Tile(3221, 3149, 0),
																										new Tile(3222, 3145, 0),
																										new Tile(3227, 3143, 0),
																										new Tile(3233, 3146, 0),
																										new Tile(3233, 3152, 0)
																										),
																										new Area(
																												new Tile(3207, 3224, 2),
																												new Tile(3207, 3218, 2),
																												new Tile(3212, 3218, 2),
																												new Tile(3212, 3224, 2)),
																												new Tile[] {
																							new Tile(3205, 3209, 0),
																							new Tile(3211, 3210, 0),
																							new Tile(3216, 3216, 0),
																							new Tile(3223, 3218, 0),
																							new Tile(3230, 3218, 0),
																							new Tile(3234, 3213, 0),
																							new Tile(3236, 3203, 0),
																							new Tile(3243, 3195, 0),
																							new Tile(3243, 3185, 0),
																							new Tile(3240, 3175, 0),
																							new Tile(3236, 3165, 0),
																							new Tile(3233, 3155, 0),
																							new Tile(3229, 3149, 0)
																						}),
																						LUMBRIDGE_SWAMP_WEST(
																								"Lumbridge Swamp (west)", 
																								new RockType[] {
																										RockType.COAL,
																										RockType.MITHRIL,
																										RockType.ADAMANTITE}, 
																										true,
																										null,
																										null,
																										new Tile[] {}),
																										MINING_GUILD(
																												"Mining Guild", 
																												new RockType[] {
																														RockType.COAL,
																														RockType.MITHRIL}, 
																														false,
																														null,
																														null,
																														new Tile[] {});


	private final String name;

	private final RockType[] rocks;

	private final boolean isVisible;

	private final Area mineArea;
	private final Area bankArea;

	private final Tile[] tilesToMine;


	private MineType(String name, RockType[] rocks, boolean isVisible, Area mineArea, Area bankArea, Tile[] tiles) {
		this.name= name;

		this.rocks = rocks;

		this.isVisible = isVisible;

		this.mineArea = mineArea;
		this.bankArea = bankArea;

		this.tilesToMine = tiles;
	}

	/**
	 * @see com.loneleh.util.display.Displayable#getName()
	 */
	@Override
	public String getName() { return name; }
	public RockType[] getRocks() { return rocks; }

	/**
	 * @see com.loneleh.util.display.Displayable#isVisible()
	 */
	@Override
	public boolean isVisible() { return isVisible; }

	public Area getMineArea() {
		return mineArea;
	}

	public Area getBankArea() {
		return bankArea;
	}

	public Tile[] getTilesToMine() {
		return tilesToMine;
	}

}
