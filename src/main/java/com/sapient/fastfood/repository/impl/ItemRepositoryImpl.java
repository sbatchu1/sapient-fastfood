package com.sapient.fastfood.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sapient.fastfood.beans.Item;
import com.sapient.fastfood.datastore.ItemStore;
import com.sapient.fastfood.repository.ItemRepository;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

	@Override
	public Map<Long, Item> fetchAll(String cuisineType, String budgetRange) {

		Map<Long, Item> items = ItemStore.fetchAll();
		Map<Long, Item> filteredItems = new HashMap<>();

		if (null != cuisineType || budgetRange != null) {
			if (null != cuisineType) {
				items.forEach((id, item) -> {

					if (item.getCuisineType().name().equals(cuisineType.trim())) {
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

	@Override
	public Item getItem(Long itemId) {
		return ItemStore.getItem(itemId);
	}

}
