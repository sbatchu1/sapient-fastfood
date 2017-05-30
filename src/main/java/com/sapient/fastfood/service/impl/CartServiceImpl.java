package com.sapient.fastfood.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.fastfood.beans.Coupon;
import com.sapient.fastfood.beans.Item;
import com.sapient.fastfood.datastore.CouponStore;
import com.sapient.fastfood.dto.BillDTO;
import com.sapient.fastfood.dto.ItemDTO;
import com.sapient.fastfood.repository.CartRepository;
import com.sapient.fastfood.repository.ItemRepository;
import com.sapient.fastfood.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public boolean add(Long userId, Long itemId) {
		Item item = itemRepository.getItem(itemId);
		//user validations to be done
		return cartRepository.add(userId, item);
	}

	@Override
	public boolean delete(Long userId, Long itemId) {
		Item item = itemRepository.getItem(itemId);
		return cartRepository.delete(userId, item);
	}

	@Override
	public BillDTO checkout(Long userId, String couponCode) {
		List<Item> cartItems = cartRepository.getCartItems(userId);
		BillDTO bill = generateBill(cartItems, couponCode);
		return bill;
	}

	private BillDTO generateBill(List<Item> cartItems, String couponCode) {
		BillDTO bill = new BillDTO();
		bill.setNumberOfItems(cartItems.size());
		double totalAmount = 0;
		for (Item item : cartItems) {
			totalAmount += item.getPrice();
		}
		bill.setTotalCartValue(totalAmount);

		// validate the coupon if any
		if (null != couponCode && CouponStore.getCoupons().containsKey(couponCode)) {
			Coupon coupon = CouponStore.getCoupons().get(couponCode);
			Timestamp currentTime = new Timestamp(System.currentTimeMillis());

			if (currentTime.before(coupon.getValidity())) {
				double dicountedAmount = totalAmount * coupon.getDiscount();
				bill.setDiscountObtained(dicountedAmount);
				bill.setAmountPayable(totalAmount - dicountedAmount);
			}
		} else {
			bill.setDiscountObtained(0);
			bill.setAmountPayable(totalAmount);
		}
		return bill;
	}

	@Override
	public List<ItemDTO> getCartItems(Long userId) {
		List<ItemDTO> itemDtos = new ArrayList<>();
		List<Item> items = cartRepository.getCartItems(userId);
		items.forEach((item) -> {
			ItemDTO dto = new ItemDTO();
			BeanUtils.copyProperties(item, dto);
			itemDtos.add(dto);
		});
		return itemDtos;
	}

}
