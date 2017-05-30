package com.sapient.fastfood.beans;

import java.math.BigDecimal;
import java.util.Map;

public class Cart {

	private String user;
	private Map<String, Integer> items;
	private BigDecimal payableAmount;
	private BigDecimal totalSavings;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Map<String, Integer> getItems() {
		return items;
	}

	public void setItems(Map<String, Integer> items) {
		this.items = items;
	}

	public BigDecimal getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(BigDecimal payableAmount) {
		this.payableAmount = payableAmount;
	}

	public BigDecimal getTotalSavings() {
		return totalSavings;
	}

	public void setTotalSavings(BigDecimal totalSavings) {
		this.totalSavings = totalSavings;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cart [user=");
		builder.append(user);
		builder.append(", items=");
		builder.append(items);
		builder.append(", payableAmount=");
		builder.append(payableAmount);
		builder.append(", totalSavings=");
		builder.append(totalSavings);
		builder.append("]");
		return builder.toString();
	}

}
