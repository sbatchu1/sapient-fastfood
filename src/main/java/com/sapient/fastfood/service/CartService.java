package com.sapient.fastfood.service;

import java.util.List;

import com.sapient.fastfood.beans.Item;
import com.sapient.fastfood.dto.BillDTO;
import com.sapient.fastfood.dto.ItemDTO;

public interface CartService {
	
	boolean add(Long userId, Long itemId);
	
	boolean delete(Long userId, Long itemId);
	
	//add checkout method
	BillDTO checkout(Long userId, String couponCode);
	
	List<ItemDTO> getCartItems(Long userId);

}
