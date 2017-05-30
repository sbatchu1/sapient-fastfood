package com.sapient.fastfood.dto;

public class BillDTO {
	private int numberOfItems;
	private double totalCartValue;
	private double amountPayable;
	private double discountObtained;

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public double getTotalCartValue() {
		return totalCartValue;
	}

	public void setTotalCartValue(double totalCartValue) {
		this.totalCartValue = totalCartValue;
	}

	public double getAmountPayable() {
		return amountPayable;
	}

	public void setAmountPayable(double amountPayable) {
		this.amountPayable = amountPayable;
	}

	public double getDiscountObtained() {
		return discountObtained;
	}

	public void setDiscountObtained(double discountObtained) {
		this.discountObtained = discountObtained;
	}

}
