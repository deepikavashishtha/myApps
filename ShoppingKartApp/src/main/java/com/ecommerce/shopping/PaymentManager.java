package com.ecommerce.shopping;

import java.util.logging.Logger;

import com.ecommerce.shopping.entity.ShoppingKart;

public class PaymentManager {
	final Logger logger = Logger.getLogger(PaymentManager.class.getName());
	/**
	 * Buy all the products in the shoppingkart and cart will be empty after successful payment
	 * @param paymentAmount
	 * @param productMetadata
	 * @return 
	 * 			true: if payment successful, when payment amount is greater or equal to total
	 * 			false: if payment amount is less than total
	 */
	public boolean buy(final ShoppingKart shoppingKart, final double paymentAmount, final ProductMetaData productMetadata) {
		final double total = shoppingKart.getTotal(productMetadata);
		boolean isPaymentSuccessful = false;
		if(paymentAmount >= total)
		{
			shoppingKart.clearCart();
			isPaymentSuccessful = true;
			logger.info("ShoppingKart Buy operation is successful");
		}
		else
		{
			logger.warning("Payment amount is less than total of all product's price.");
		}
		return isPaymentSuccessful;
	}
}
