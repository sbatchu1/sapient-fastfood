package com.sapient.fastfood.repository;

import java.util.Map;

import com.sapient.fastfood.resource.Item;

public interface ItemRepository {
	Map<Long, Item> fetchAll(String cuisineType, String budgetRange);
}
