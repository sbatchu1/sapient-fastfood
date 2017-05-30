package com.sapient.fastfood.repository;

import java.util.List;

import com.sapient.fastfood.beans.Item;

public interface CartRepository {
	boolean add(Long userId, Item item);

	boolean delete(Long userId, Item item);
	
	List<Item> getCartItems(Long userId);
}
