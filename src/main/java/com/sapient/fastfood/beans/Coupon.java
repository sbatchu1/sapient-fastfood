package com.sapient.fastfood.beans;

import java.sql.Timestamp;

public class Coupon {

	private Timestamp validity;
	private double discount;

	public Coupon(Timestamp validity, double discount) {
		super();
		this.validity = validity;
		this.discount = discount;
	}

	public Timestamp getValidity() {
		return validity;
	}

	public void setValidity(Timestamp validity) {
		this.validity = validity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
