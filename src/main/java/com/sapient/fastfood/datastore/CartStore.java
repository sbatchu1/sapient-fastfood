package com.sapient.fastfood.datastore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sapient.fastfood.beans.Item;

public class CartStore {
	public static Map<Long, List<Item>> cart = new HashMap<>();
}
