package com.sapient.fastfood.service;

import java.util.List;

import com.sapient.fastfood.dto.ItemDTO;

public interface ItemService {

	List<ItemDTO> fetchAll(String cuisineType, String budgetRange);

}
