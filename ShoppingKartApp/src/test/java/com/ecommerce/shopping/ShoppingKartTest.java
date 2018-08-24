package com.ecommerce.shopping;

import org.junit.Before;
import org.junit.Test;

import com.ecommerce.shopping.entity.Customer;
import com.ecommerce.shopping.entity.ShoppingKart;

import junit.framework.Assert;


public class ShoppingKartTest {
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
	}

	@Test
	public void addProduct()
	{
		Assert.assertNull("ShoppingKart should be empty in the biginning", shoppingKart1.getProductQuantity(1));
		shoppingKart1.addProduct(1, 2);
		Assert.assertEquals("ShoppingKart does not have expected product quantity", 2, shoppingKart1.getProductQuantity(1).intValue());
		shoppingKart1.addProduct(1, 2);
		Assert.assertEquals("ShoppingKart does not have expected product quantity", 4, shoppingKart1.getProductQuantity(1).intValue());
	}

	@Test
	public void removeProductUpdatingQuantityWithSucess()
	{
		Assert.assertNull("ShoppingKart should be empty in the biginning", shoppingKart1.getProductQuantity(2));
		shoppingKart1.addProduct(2, 5);
		Assert.assertEquals("ShoppingKart does not have expected product quantity", 5, shoppingKart1.getProductQuantity(2).intValue());
		boolean removeProductResult = shoppingKart1.removeProduct(2, 3);
		Assert.assertEquals("ShoppingKart does not have expected product quantity", 2, shoppingKart1.getProductQuantity(2).intValue());
		Assert.assertEquals("Should be able to remove product from ShoppingKart", true, removeProductResult);
	}

	@Test
	public void removeProductUpdatingQuantityWithFail()
	{
		Assert.assertNull("ShoppingKart should be empty in the biginning", shoppingKart1.getProductQuantity(4));
		shoppingKart1.addProduct(4, 5);
		Assert.assertEquals("ShoppingKart does not have expected product quantity", 5, shoppingKart1.getProductQuantity(4).intValue());
		boolean removeProductResult = shoppingKart1.removeProduct(4, 7);
		Assert.assertEquals("Should be able to remove product from ShoppingKart", false, removeProductResult);
	}

	@Test
	public void removeProductEntirely()
	{
		Assert.assertNull("ShoppingKart should be empty in the biginning", shoppingKart1.getProductQuantity(6));
		shoppingKart1.addProduct(6, 5);
		Assert.assertEquals("ShoppingKart does not have expected product quantity", 5, shoppingKart1.getProductQuantity(6).intValue());
		boolean removeProductResult = shoppingKart1.removeProduct(6, 5);
		Assert.assertEquals("Should be able to remove product from ShoppingKart", true, removeProductResult);
		Assert.assertNull("ShoppingKart does not have expected product quantity", shoppingKart1.getProductQuantity(6));
	}

	@Test
	public void removeProductWhenNotExistInShoppingKart()
	{
		boolean removeProductResult = shoppingKart1.removeProduct(5, 3);
		Assert.assertEquals("Should be able to remove product from ShoppingKart", false, removeProductResult);
	}

	@Test
	public void total()
	{
		double total = shoppingKart1.getTotal(productMetadata);
		shoppingKart1.addProduct(10, 2);
		Assert.assertEquals("ShoppingKart does not have expected total value", total + 11, shoppingKart1.getTotal(productMetadata));
	}

}
