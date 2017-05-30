package com.sapient.fastfood.datastore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.sapient.fastfood.beans.Item;
import com.sapient.fastfood.constant.CuisineType;

public class ItemStore {

	private static final AtomicLong itemId = new AtomicLong(1);
	private static final Map<Long, Item> ITEM_MAP = new HashMap<>(5);

	static {
		initializeData();
	}

	private static void initializeData() {
		Item idly = new Item(itemId.getAndIncrement(), "Idly", 25.00, CuisineType.SOUTH_INDIAN);
		ITEM_MAP.put(idly.getId(), idly);

		Item dosa = new Item(itemId.getAndIncrement(), "Dosa", 30.00, CuisineType.SOUTH_INDIAN);
		ITEM_MAP.put(dosa.getId(), dosa);

		Item vegFriedRice = new Item(itemId.getAndIncrement(), "Veg Fried Rice", 120.00, CuisineType.CHINESE);
		ITEM_MAP.put(vegFriedRice.getId(), vegFriedRice);

		Item noodles = new Item(itemId.getAndIncrement(), "Noodles", 135.00, CuisineType.CHINESE);
		ITEM_MAP.put(noodles.getId(), noodles);

		Item pasta = new Item(itemId.getAndIncrement(), "Pasta", 70.00, CuisineType.CONTINENTAL);
		ITEM_MAP.put(pasta.getId(), pasta);
	}

	public static Map<Long, Item> fetchAll() {
		return ITEM_MAP;
	}

	public static Item getItem(Long itemId) {
		return ITEM_MAP.get(itemId);
	}
}
