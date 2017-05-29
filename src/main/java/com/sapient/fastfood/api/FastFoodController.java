package com.sapient.fastfood.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.fastfood.resource.Item;
import com.sapient.fastfood.service.ItemService;

@RestController
@RequestMapping("/")
public class FastFoodController {

	@Autowired
	private ItemService itemService;

	/**
	 * Returns all the items of the menu, further filters based on the search
	 * criteria cuisine type, budget
	 * 
	 * @return
	 */
	@RequestMapping(value = "get-items", method = RequestMethod.GET)
	public Collection<Item> getCuisines(
			@RequestParam(value = "cuisineType", required = false) String cuisineType,
			@RequestParam(value = "budgetRange", required = false) String budgetRange) {
		return itemService.fetchAll(cuisineType, budgetRange);
	}

}
