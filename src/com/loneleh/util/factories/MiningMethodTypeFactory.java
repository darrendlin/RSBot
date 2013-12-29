/**
 * 
 */
package com.loneleh.util.factories;

import java.util.Hashtable;
import java.util.logging.Logger;

import com.loneleh.game.mining.MiningMethodType;
import com.loneleh.script.LonelehMining;

/**
 * MiningMethodTypeFactory.java
 * 
 * @author Loneleh
 */
public class MiningMethodTypeFactory
{
	private static Hashtable<String, MiningMethodType> methodTable;
	
	static
	{
		methodTable = new Hashtable<String, MiningMethodType>();
		
		for (MiningMethodType t : MiningMethodType.values())
			methodTable.put(t.getName(), t);
	}
	
	/**
	 * Returns a <code>MiningMethodType</code> enum value.
	 * @param type String representation of the MiningMethodType enum to be returned, as specified by <code>MiningMethodType</code>.
	 * @return the <code>MiningMethodType</code> enum value.
	 */
	public static MiningMethodType getMiningMethod(String type)
	{
		if (methodTable.containsKey(type)) {
			return methodTable.get(type);
		} else {
			Logger.getLogger(LonelehMining.class.getName()).severe("Invalid MiningMethodType type: " + type);
		}
		return MiningMethodType.values()[0];
	}
}
