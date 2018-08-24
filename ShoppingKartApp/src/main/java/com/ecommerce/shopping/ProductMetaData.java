package com.ecommerce.shopping;

import java.util.HashMap;
import java.util.Map;

import com.ecommerce.shopping.entity.Product;

public class ProductMetaData {

	/**
	 * This map maintains available product and their price mapping.
	 */
	Map<Integer, Product> productMapping = new HashMap<Integer, Product>();
	
	public void addProduct(final int id, final float price)
	{
		productMapping.put(id, new Product(id, price));
	}
	 
	public float getPrice(final int id)
	{
		return productMapping.get(id).getPrice();
	}
}
