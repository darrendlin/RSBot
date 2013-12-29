/**
 * 
 */
package com.loneleh.game.mining.abstracted;

import java.util.Comparator;

import org.powerbot.script.util.GeItem;
import org.powerbot.script.util.GeItem.PriceType;

import com.loneleh.game.mining.MineralType;
import com.loneleh.util.abstracted.Valuable;

/**
 * Minable.java
 * 
 * @author Loneleh
 */
public abstract class Minable implements Valuable
{
	protected int id;
	protected String name;
	protected int price;
	protected double exp;
	
	private final MineralType mineralType;
	
	
	public Minable(MineralType type) {
		this.id = type.getId();
		initGeItem();
		this.exp = type.getExp();
		this.mineralType = type;
	}
	
	public double getExp() {
		return exp;
	}
	
	public void initGeItem() {
		GeItem item = GeItem.getProfile(id);
		price = item.getPrice(PriceType.CURRENT).getPrice();
		name = item.getName();
	}
	
	/* (non-Javadoc)
	 * @see com.loneleh.util.interfaces.Valuable#getGeItem()
	 */
	@Override
	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	
	/**
	 * Sets the priority of the associated MineralType, rather than setting its own priority
	 * @param priority
	 */
	public void setPriority(int priority) {
		mineralType.setPriority(priority);
	}
	
	public MineralType getMineralType() {
		return mineralType;
	}
	
	public abstract boolean isGem();
	
}
