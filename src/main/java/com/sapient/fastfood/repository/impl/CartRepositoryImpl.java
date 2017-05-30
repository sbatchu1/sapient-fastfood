package com.sapient.fastfood.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sapient.fastfood.beans.Item;
import com.sapient.fastfood.datastore.CartStore;
import com.sapient.fastfood.repository.CartRepository;

@Repository
public class CartRepositoryImpl implements CartRepository {

	@Override
	public boolean add(Long userId, Item item) {
		List<Item> cartItems = null;
		if (null != CartStore.cart.get(userId)) {
			cartItems = CartStore.cart.get(userId);
		} else {
			cartItems = new ArrayList<>();
		}

		cartItems.add(item);
		CartStore.cart.put(userId, cartItems);
		return true;
	}

	@Override
	public boolean delete(Long userId, Item item) {
		List<Item> cartItems = CartStore.cart.get(userId);
		cartItems.remove(item);
		CartStore.cart.put(userId, cartItems);
		return true;
	}

	@Override
	public List<Item> getCartItems(Long userId) {
		return CartStore.cart.get(userId);
	}
}
