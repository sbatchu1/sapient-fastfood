package com.sapient.fastfood.resource;

import com.sapient.fastfood.constant.CuisineType;

/**
 * Represents a food item in the menu
 * 
 * @author sbatc1
 *
 */
public class Item {

	private long id;
	private String name;
	private double price;
	private CuisineType cuisineType;

	public Item(long id, String name, double price, CuisineType cuisineType) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.cuisineType = cuisineType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuisineType == null) ? 0 : cuisineType.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (cuisineType != other.cuisineType)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CuisineType getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(CuisineType cuisineType) {
		this.cuisineType = cuisineType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", cuisineType=");
		builder.append(cuisineType);
		builder.append("]");
		return builder.toString();
	}

}
