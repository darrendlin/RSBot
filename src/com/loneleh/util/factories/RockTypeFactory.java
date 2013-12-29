/**
 * 
 */
package com.loneleh.util.factories;

import java.util.Hashtable;
import java.util.logging.Logger;

import com.loneleh.game.mining.MineralType;
import com.loneleh.game.mining.RockType;
import com.loneleh.script.LonelehMining;

/**
 * RockTypeFactory.java
 * 
 * @author Loneleh
 */
public class RockTypeFactory
{
	private static Hashtable<MineralType, RockType> mineralToRockTable;
	private static Hashtable<String, RockType> rockStringToRockTable;
	
	static
	{
		mineralToRockTable = new Hashtable<MineralType, RockType>();
		rockStringToRockTable = new Hashtable<String, RockType>();

		for (RockType t : RockType.values()) {
			mineralToRockTable.put(t.getMineral(), t);
			rockStringToRockTable.put(t.getName(), t);
		}
	}
	
	public static RockType getRock(MineralType type) {
		if (type.isGem()) {
			Logger.getLogger(LonelehMining.class.getName()).severe("Non-gems only: " + type.getName());
		}
		if (mineralToRockTable.containsKey(type)) {
			return mineralToRockTable.get(type);
		} else {
			Logger.getLogger(LonelehMining.class.getName()).severe("Invalid MineralType type: " + type.getName());
		}
		return RockType.values()[0];
	}
	
	public static RockType getRock(String rock) {
		if (rockStringToRockTable.containsKey(rock)) {
			return rockStringToRockTable.get(rock);
		} else {
			Logger.getLogger(LonelehMining.class.getName()).severe("Invalid RockType type: " + rock);
		}
		return RockType.values()[0];
	}
}
