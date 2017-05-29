package com.sapient.fastfood.service;

import java.util.List;

import com.sapient.fastfood.resource.Item;

public interface ItemService {

	List<Item> fetchAll(String cuisineType, String budgetRange);

}
