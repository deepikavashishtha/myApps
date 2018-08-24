package com.example.colors.customer;

import java.util.List;

import com.example.colors.ColorBatchPool;
import com.example.colors.rules.CustomerWithSingleOrder;
import com.example.colors.rules.Rule;
import com.example.colors.rules.SortingRule;

/**
 * This class gives the implementation for OrderHandler class.
 * @author Deepika Vashishtha
 *
 */
public class OrderHandlerImpl implements OrderHandler {
	@Override
	public void processOrders(List<Customer> customers) {
		System.out.println("taking order");

		preapreRule().applyRule(customers);
	}

	private Rule preapreRule() {
		final Rule ruleChain = new SortingRule();
		final Rule singleOrderRule = new CustomerWithSingleOrder();

		ruleChain.setNextRule(singleOrderRule);
		return ruleChain;
	}
	@Override
	public void colorCount(String count) {
		ColorBatchPool.instance().setup(count);
	}

}
