package com.sapient.fastfood.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sapient.fastfood.datastore.ItemStore;
import com.sapient.fastfood.repository.ItemRepository;
import com.sapient.fastfood.resource.Item;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

	@Override
	public Map<Long, Item> fetchAll(String cuisineType, String budgetRange) {

		Map<Long, Item> items = ItemStore.fetchAll();
		Map<Long, Item> filteredItems = new HashMap<>();

		if (null != cuisineType || budgetRange != null) {
			if (null != cuisineType) {
				items.forEach((id, item) -> {
					if (cuisineType.equals(item.getCuisineType())) {
						filteredItems.put(id, item);
					}
				});
			}

			// TODO: similarly use budget Range filter

			return filteredItems;
		} else {
			return items;
		}

	}

}
