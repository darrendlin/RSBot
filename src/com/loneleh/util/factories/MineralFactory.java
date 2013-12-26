/**
 * 
 */
package com.loneleh.util.factories;

import java.util.Hashtable;

import com.loneleh.game.mining.Gem;
import com.loneleh.game.mining.MineralType;
import com.loneleh.game.mining.Ore;
import com.loneleh.game.mining.abstracted.Minable;

/**
 * MineralFactory.java
 * 
 * @author Loneleh
 */
public class MineralFactory
{
	private static Hashtable<String, MineralType> oreTable;
	private static Hashtable<String, MineralType> gemTable;
	
	static
	{
		oreTable = new Hashtable<String, MineralType>();
		gemTable = new Hashtable<String, MineralType>();
		
		for (MineralType t : MineralType.values())
			if (t.isGem())
				gemTable.put(t.getName(), t);
			else
				oreTable.put(t.getName(), t);
	}
	
	/**
	 * Creates a new <code>Mineral</code> object.
	 * @param type String representation of the Mineral object to be created, as specified by <code>MineralType</code>.
	 * @return the new <code>Mineral</code> object.
	 */
	public static Minable getMineral(String type)
	{
		if (oreTable.containsKey(type)) {
			return new Ore(oreTable.get(type));
		} else if (gemTable.containsKey(type)) {
			return new Gem(gemTable.get(type));
		} else {
			//TODO some sort of error reporting... which shouldn't even happen
		}
		return null;
	}
}
