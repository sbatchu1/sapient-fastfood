package com.sapient.fastfood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.fastfood.dto.ItemDTO;
import com.sapient.fastfood.repository.ItemRepository;
import com.sapient.fastfood.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;

	@Override
	public List<ItemDTO> fetchAll(String cuisineType, String budgetRange) {
		List<ItemDTO> items = new ArrayList<>();
		itemRepository.fetchAll(cuisineType, budgetRange).forEach((id, item) -> {
			ItemDTO dto = new ItemDTO();
			BeanUtils.copyProperties(item, dto);
			items.add(dto);
		});
		return items;
	}

}
