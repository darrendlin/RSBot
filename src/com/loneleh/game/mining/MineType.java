/**
 * 
 */
package com.loneleh.game.mining;

import com.loneleh.util.display.Displayable;
import com.loneleh.util.helper.Condition;


/**
 * Mine.java
 * 
 * @author Loneleh
 */
public enum MineType implements Displayable
{	
	AL_KHARID("Al Kharid", new RockType[] {RockType.TIN,
										   RockType.COPPER,
										   RockType.IRON, 
										   RockType.COAL, 
										   RockType.SILVER, 
										   RockType.GOLD, 
										   RockType.MITHRIL, 
										   RockType.ADAMANTITE}, 
			  new Condition() {
		@Override
		public boolean validate()
		{
			return true;
		}}, false),
	BARBARIAN_VILLAGE("Barbarian Village", new RockType[] {RockType.TIN,
													   	   RockType.COAL}, 
					  new Condition() {
		@Override
		public boolean validate()
		{
			return true;
		}}, false),
	CRAFTING_GUILD("Crafting Guild", new RockType[] {RockType.CLAY, 
												 	 RockType.SILVER, 
												 	 RockType.GOLD}, 
				   new Condition() {
		@Override
		public boolean validate()
		{
			return false; // level 40 crafting + wearing brown apron
		}}, false),
	DWARVEN_MINE("Dwarven Mine", new RockType[] {RockType.CLAY, 
											 	 RockType.COPPER, 
											 	 RockType.TIN, 
											 	 RockType.IRON, 
											 	 RockType.COAL, 
											 	 RockType.GOLD, 
											 	 RockType.MITHRIL, 
											 	 RockType.ADAMANTITE}, 
				  new Condition() {
		@Override
		public boolean validate()
		{
			return false;
		}}, false),
	EDGEVILLE_DUNGEON_MINE("Edgeville Dungeon Mine", new RockType[] {RockType.COPPER, 
																 	 RockType.TIN, 
																 	 RockType.IRON, 
																 	 RockType.SILVER, 
																 	 RockType.COAL, 
																 	 RockType.MITHRIL, 
																 	 RockType.ADAMANTITE}, 
						   new Condition() {
		@Override
		public boolean validate()
		{
			return false;
		}}, false),
	LUMBRIDGE_SWAMP_EAST("Lumbridge Swamp (east)", new RockType[] {RockType.COPPER,
																   RockType.TIN}, 
						 new Condition() {
		@Override
		public boolean validate()
		{
			return true;
		}}, false),
	LUMBRIDGE_SWAMP_WEST("Lumbridge Swamp (west)", new RockType[] {RockType.COAL,
															   	   RockType.MITHRIL,
															   	   RockType.ADAMANTITE},
						 new Condition() {
		@Override
		public boolean validate()
		{
			return true;
		}}, false),
	MINING_GUILD("Mining Guild", new RockType[] {RockType.COAL,
											  	 RockType.MITHRIL}, 
				 new Condition() {
		@Override
		public boolean validate()
		{
			return false; // lv 60 mining
		}}, false);
	
	
	private final String name;
	
	private final RockType[] rocks;
	
	/**
	 * {@link Condition#validate()} must return true before the user is allowed to select it.
	 * This can include qualifications (levels, equipment) to enter a specific area, etc.
	 */
	private final Condition condition;
	
	private final boolean isMember;
	
	private MineType(String name, RockType[] rocks, Condition condition, boolean isMember) {
		this.name= name;
		
		this.rocks = rocks;
		
		this.condition = condition;
		
		this.isMember = isMember;
	}
	
	/* (non-Javadoc)
	 * @see com.loneleh.util.display.Displayable#getName()
	 */
	@Override
	public String getName() { return name; }
	public RockType[] getRocks() { return rocks; }
	/* (non-Javadoc)
	 * @see com.loneleh.util.display.Displayable#isVisible()
	 */
	@Override
	public boolean isVisible() { return condition.validate(); }
	public boolean isMember() { return isMember; }
}
