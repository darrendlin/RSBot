package com.loneleh.scripts.framework.enums;

import com.loneleh.util.helper.Condition;

public enum Mine
{	
	AL_KHARID("Al Kharid", new Condition() {
		@Override
		public boolean validate()
		{
			return true;
		}}, false),
	BARBARIAN_VILLAGE("Barbarian Village", new Condition() {
		@Override
		public boolean validate()
		{
			return true;
		}}, false),
	CRAFTING_GUILD("Crafting Guild", new Condition() {
		@Override
		public boolean validate()
		{
			return false; // level 40 crafting + wearing brown apron
		}}, false),
	DWARVEN_MINE("Dwarven Mine", new Condition() {
		@Override
		public boolean validate()
		{
			return false;
		}}, false),
	EDGEVILLE_DUNGEON_MINE("Edgeville Dungeon Mine", new Condition() {
		@Override
		public boolean validate()
		{
			return false;
		}}, false),
	LUMBRIDGE_SWAMP_EAST("Lumbridge Swamp (east)", new Condition() {
		@Override
		public boolean validate()
		{
			return true;
		}}, false),
	LUMBRIDGE_SWAMP_WEST("Lumbridge Swamp (west)", new Condition() {
		@Override
		public boolean validate()
		{
			return true;
		}}, false),
	MINING_GUILD("Mining Guild", new Condition() {
		@Override
		public boolean validate()
		{
			return false; // lv 60 mining
		}}, false);
	
	public final String name;
	
	public final Condition condition; // true or false before user's allowed to select it
	
	public final boolean isMember;
	
	Mine(String name, Condition condition, boolean isMember)
	{
		this.name= name;
		
		this.condition = condition;
		
		this.isMember = isMember;
	}
	
	public final String getName() { return name; }
	public final boolean isVisibleOnGUI() { return condition.validate(); }
	public final boolean isMember() { return isMember; }
}
