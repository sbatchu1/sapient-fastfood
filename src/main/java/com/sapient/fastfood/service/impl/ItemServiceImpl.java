package com.sapient.fastfood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.fastfood.repository.ItemRepository;
import com.sapient.fastfood.resource.Item;
import com.sapient.fastfood.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;

	@Override
	public List<Item> fetchAll(String cuisineType, String budgetRange) {
		List<Item> items = new ArrayList<>();
		itemRepository.fetchAll(cuisineType, budgetRange).forEach((id, item) -> {
			items.add(item);
		});
		return items;
	}

}
