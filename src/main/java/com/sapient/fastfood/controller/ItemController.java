package com.sapient.fastfood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.fastfood.dto.ItemDTO;
import com.sapient.fastfood.service.ItemService;

@RestController
@RequestMapping("/")
public class ItemController {

	@Autowired
	private ItemService itemService;

	/**
	 * Returns all the items of the menu, further filters based on the search
	 * criteria cuisine type, budget
	 * 
	 * @return
	 */
	@RequestMapping(value = "get-items", method = RequestMethod.GET)
	public ResponseEntity<List<ItemDTO>> getCuisines(
			@RequestParam(value = "cuisineType", required = false) String cuisineType,
			@RequestParam(value = "budgetRange", required = false) String budgetRange) {
		return new ResponseEntity<List<ItemDTO>>(itemService.fetchAll(cuisineType, budgetRange), HttpStatus.OK);
	}



}
