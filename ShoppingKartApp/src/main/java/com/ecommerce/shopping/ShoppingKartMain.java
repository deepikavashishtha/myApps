package com.ecommerce.shopping;

import com.ecommerce.shopping.entity.Customer;
import com.ecommerce.shopping.entity.ShoppingKart;

/**
 * This is main entry point for ShpooingKart application
 * @author Deepika Vashishtha
 *
 */
public class ShoppingKartMain {
	ProductMetaData productMetadata = new ProductMetaData();
	 
	public static void main(String[] args) {
		ShoppingKartMain shoppingCardMain = new ShoppingKartMain();
		PaymentManager paymentManager = new PaymentManager();
		Customer customer1=  new Customer(1, "Jane");
		ShoppingKart shoppingKart1 = new ShoppingKart(customer1.getId());
		//Initializing ProductMetadata
		initProduct(shoppingCardMain);
				
		//Adding products for customer
		shoppingKart1.addProduct(1, 2);
		shoppingKart1.addProduct(2, 4);
		shoppingKart1.addProduct(3, 3);
		shoppingKart1.addProduct(7, 1);
		shoppingKart1.addProduct(10, 7);
		
		//removing products for customer
		shoppingKart1.removeProduct(1, 1);
		shoppingKart1.removeProduct(5, 6);
		shoppingKart1.removeProduct(2, 7);
		shoppingKart1.removeProduct(10, 3);
		
		//Total price of products inShoppingKart
		double total = shoppingKart1.getTotal(shoppingCardMain.productMetadata);
		
		//Buy products available in ShoppingKart
		paymentManager.buy(shoppingKart1, total, shoppingCardMain.productMetadata);
	}


	private static void initProduct(ShoppingKartMain shoppingCardMain) {
		shoppingCardMain.productMetadata.addProduct(1, 2);
		shoppingCardMain.productMetadata.addProduct(3, 6);
		shoppingCardMain.productMetadata.addProduct(5, 8.5f);
		shoppingCardMain.productMetadata.addProduct(8, 5.5f);
		shoppingCardMain.productMetadata.addProduct(2, 2);
		shoppingCardMain.productMetadata.addProduct(4, 6);
		shoppingCardMain.productMetadata.addProduct(6, 8.5f);
		shoppingCardMain.productMetadata.addProduct(7, 5.5f);
		shoppingCardMain.productMetadata.addProduct(9, 8.5f);
		shoppingCardMain.productMetadata.addProduct(10, 5.5f);
	}

}
