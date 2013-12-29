package com.loneleh.game.miningsmithing_;

import com.loneleh.util.display.Displayable;
import com.loneleh.util.helper.Conditional;


/**
 * Mine.java
 * 
 * @author Loneleh
 */
@Deprecated
public enum Mine implements Displayable
{	
	AL_KHARID("Al Kharid", new Rock[] {Rock.TIN,
									   Rock.COPPER,
									   Rock.IRON, 
									   Rock.COAL, 
									   Rock.SILVER, 
									   Rock.GOLD, 
									   Rock.MITHRIL, 
									   Rock.ADAMANTITE}, 
			  new Conditional() {
		@Override
		public boolean validate()
		{
			return true;
		}}, false),
	BARBARIAN_VILLAGE("Barbarian Village", new Rock[] {Rock.TIN,
													   Rock.COAL}, 
					  new Conditional() {
		@Override
		public boolean validate()
		{
			return true;
		}}, false),
	CRAFTING_GUILD("Crafting Guild", new Rock[] {Rock.CLAY, 
												 Rock.SILVER, 
												 Rock.GOLD}, 
				   new Conditional() {
		@Override
		public boolean validate()
		{
			return false; // level 40 crafting + wearing brown apron
		}}, false),
	DWARVEN_MINE("Dwarven Mine", new Rock[] {Rock.CLAY, 
											 Rock.COPPER, 
											 Rock.TIN, 
											 Rock.IRON, 
											 Rock.COAL, 
											 Rock.GOLD, 
											 Rock.MITHRIL, 
											 Rock.ADAMANTITE}, 
				  new Conditional() {
		@Override
		public boolean validate()
		{
			return false;
		}}, false),
	EDGEVILLE_DUNGEON_MINE("Edgeville Dungeon Mine", new Rock[] {Rock.COPPER, 
																 Rock.TIN, 
																 Rock.IRON, 
																 Rock.SILVER, 
																 Rock.COAL, 
																 Rock.MITHRIL, 
																 Rock.ADAMANTITE}, 
						   new Conditional() {
		@Override
		public boolean validate()
		{
			return false;
		}}, false),
	LUMBRIDGE_SWAMP_EAST("Lumbridge Swamp (east)", new Rock[] {Rock.COPPER,
															   Rock.TIN}, 
						 new Conditional() {
		@Override
		public boolean validate()
		{
			return true;
		}}, false),
	LUMBRIDGE_SWAMP_WEST("Lumbridge Swamp (west)", new Rock[] {Rock.COAL,
															   Rock.MITHRIL,
															   Rock.ADAMANTITE},
						 new Conditional() {
		@Override
		public boolean validate()
		{
			return true;
		}}, false),
	MINING_GUILD("Mining Guild", new Rock[] {Rock.COAL,
											 Rock.MITHRIL}, 
				 new Conditional() {
		@Override
		public boolean validate()
		{
			return false; // lv 60 mining
		}}, false);
	
	
	private final String name;
	
	private final Rock[] rocks;
	
	/**
	 * {@link Condition#validate()} must return true before the user is allowed to select it.
	 * This can include qualifications (levels, equipment) to enter a specific area, etc.
	 */
	private final Conditional condition;
	
	private final boolean isMember;
	
	Mine(String name, Rock[] rocks, Conditional condition, boolean isMember)
	{
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
	public Rock[] getRocks() { return rocks; }
	/* (non-Javadoc)
	 * @see com.loneleh.util.display.Displayable#isVisible()
	 */
	@Override
	public boolean isVisible() { return condition.validate(); }
	public boolean isMember() { return isMember; }
}
