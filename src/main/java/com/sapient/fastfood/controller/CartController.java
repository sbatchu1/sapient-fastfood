package com.sapient.fastfood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.fastfood.dto.BillDTO;
import com.sapient.fastfood.dto.ItemDTO;
import com.sapient.fastfood.service.CartService;

@RestController
@RequestMapping("/")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping(value = "cart/{itemId}/add", method = RequestMethod.PUT)
	public ResponseEntity<String> addToCart(@PathVariable long itemId,
			@RequestParam(value = "userId", required = true) Long userId) {

		cartService.add(userId, itemId);
		return new ResponseEntity<String>("success", HttpStatus.OK);

	}

	@RequestMapping(value = "cart/checkOut", method = RequestMethod.POST)
	public ResponseEntity<BillDTO> checkOut(@RequestParam Long userId,
			@RequestParam(value = "couponCode", required = false) String couponCode) {
		return new ResponseEntity<BillDTO>(cartService.checkout(userId, couponCode), HttpStatus.OK);
	}

	@RequestMapping(value = "cart/get-items", method = RequestMethod.GET)
	public ResponseEntity<List<ItemDTO>> getCartItems(@RequestParam(value = "userId", required = true) Long userId) {
		return new ResponseEntity<List<ItemDTO>>(cartService.getCartItems(userId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "cart/{itemId}/remove", method = RequestMethod.PUT)
	public ResponseEntity<String> removeFromCart(@PathVariable long itemId,
			@RequestParam(value = "userId", required = true) Long userId) {

		cartService.delete(userId, itemId);
		return new ResponseEntity<String>("success", HttpStatus.OK);

	}

}
