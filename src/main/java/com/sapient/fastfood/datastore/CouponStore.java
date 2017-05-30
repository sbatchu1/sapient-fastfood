package com.sapient.fastfood.datastore;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.sapient.fastfood.beans.Coupon;

public class CouponStore {

	private static final Map<String, Coupon> COUPONS = new HashMap<>(5);

	static {
		initializeData();
	}

	private static void initializeData() {
		// Date dt = new Date();
		// LocalDateTime validDate =
		// LocalDateTime.from(dt.toInstant()).plusDays(1);
		// ZonedDateTime zdt = validDate.atZone(ZoneId.of("Asia/Kolkata"));

		Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
		long oneDay = 1 * 24 * 60 * 60 * 1000;
		Timestamp validityTimestamp = new Timestamp(currentTimeStamp.getTime() + oneDay);

		COUPONS.put("FIRST10", new Coupon(validityTimestamp, 0.1));
		COUPONS.put("FESTI20", new Coupon(validityTimestamp, 0.2));
		COUPONS.put("REFER15", new Coupon(validityTimestamp, 0.15));
		COUPONS.put("BIGBI30", new Coupon(validityTimestamp, 0.3));
	}

	public static Map<String, Coupon> getCoupons() {
		return COUPONS;
	}

}
