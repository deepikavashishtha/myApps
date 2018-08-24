package com.ecommerce.shopping;

import org.junit.Before;
import org.junit.Test;

import com.ecommerce.shopping.entity.Customer;
import com.ecommerce.shopping.entity.ShoppingKart;

import junit.framework.Assert;

public class PaymentManagerTest {
	PaymentManager paymentManager = new PaymentManager();
	ProductMetaData productMetadata = new ProductMetaData();
	Customer customer1 ;
	ShoppingKart shoppingKart1 ;

	@Before
	public void setup()
	{
		productMetadata.addProduct(1, 2);
		productMetadata.addProduct(3, 6);
		productMetadata.addProduct(5, 8.5f);
		productMetadata.addProduct(8, 5.5f);
		productMetadata.addProduct(2, 2);
		productMetadata.addProduct(4, 6);
		productMetadata.addProduct(6, 8.5f);
		productMetadata.addProduct(7, 5.5f);
		productMetadata.addProduct(9, 8.5f);
		productMetadata.addProduct(10, 5.5f);
		customer1 =  new Customer(1, "Jane");
		shoppingKart1 = new ShoppingKart(customer1.getId());
		shoppingKart1.addProduct(1, 2);
		shoppingKart1.addProduct(2, 4);
	}

	@Test
	public void buySuccessful()
	{
		double total = shoppingKart1.getTotal(productMetadata);
		boolean isBuySuccessful = paymentManager.buy(shoppingKart1, total, productMetadata);
		Assert.assertTrue("Buy should be successful", isBuySuccessful);
		total = shoppingKart1.getTotal(productMetadata);
		Assert.assertEquals("Total should be 0 , after succesful buy operation", 0.0, total);
	}

	@Test
	public void buyFail()
	{
		double total = shoppingKart1.getTotal(productMetadata);
		boolean isBuySuccessful = paymentManager.buy(shoppingKart1, total-1, productMetadata);
		Assert.assertFalse("Buy should  Fail", isBuySuccessful);
	}
}
