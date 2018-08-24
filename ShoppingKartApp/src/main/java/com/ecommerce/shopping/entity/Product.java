package com.ecommerce.shopping.entity;

/**
 * This class represents Product.
 * @author Deepika Vashishtha
 *
 */
public class Product {
	private int id;
	private float price;
	
	public Product(final int id, final float price) {
		super();
		this.id = id;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public float getPrice() {
		return price;
	}
}	
