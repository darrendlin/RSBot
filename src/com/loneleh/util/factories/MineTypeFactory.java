/**
 * 
 */
package com.loneleh.util.factories;

import java.util.Hashtable;
import java.util.logging.Logger;

import com.loneleh.game.mining.MineType;
import com.loneleh.script.LonelehMining;

/**
 * MineTypeFactory.java
 * 
 * @author Loneleh
 */
public class MineTypeFactory
{
	private static Hashtable<String, MineType> mineTable;
	
	
	static
	{
		mineTable = new Hashtable<String, MineType>();

		for (MineType t : MineType.values())
			mineTable.put(t.getName(), t);
	}

	/**
	 * Returns a <code>MineType</code> enum value.
	 * @param type String representation of the MineType object to be created, as specified by <code>MineType</code>.
	 * @return the <code>MineType</code> enum value.
	 */
	public static MineType getMine(String type)
	{
		if (mineTable.containsKey(type)) {
			return mineTable.get(type);
		} else {
			Logger.getLogger(LonelehMining.class.getName()).severe("Invalid MineType type: " + type);
		}
		return MineType.values()[0];
	}
}
