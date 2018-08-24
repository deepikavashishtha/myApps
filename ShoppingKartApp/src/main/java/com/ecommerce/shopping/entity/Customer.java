package com.ecommerce.shopping.entity;

/**
 * This is a customer class. It contains property of customer.
 * @author Deepika Vashishtha
 *
 */
public class Customer {
	int id;
	String name;
	
	
	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

}
