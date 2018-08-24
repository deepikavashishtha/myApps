package com.example.colors.customer;

import java.util.List;

/**
 * This class exposes interface to process order and color counting.
 * @author Deepika Vashishtha
 *
 */
public interface OrderHandler {
	void processOrders(List<Customer> customers);

	void colorCount(String count);
}
