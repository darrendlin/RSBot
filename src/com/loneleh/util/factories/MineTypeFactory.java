/**
 * 
 */
package com.loneleh.util.factories;

import java.util.Hashtable;

import com.loneleh.game.mining.MineType;

/**
 * MineFactory.java
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
	 * Creates a new <code>Mineral</code> object.
	 * @param type String representation of the Mineral object to be created, as specified by <code>MineralType</code>.
	 * @return the new <code>Mineral</code> object.
	 */
	public static MineType getMine(String type)
	{
		if (mineTable.containsKey(type)) {
			return mineTable.get(type);
		} else {
			//TODO some sort of error reporting... which shouldn't even happen
		}
		return null;
	}
}
