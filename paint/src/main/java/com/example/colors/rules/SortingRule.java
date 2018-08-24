package com.example.colors.rules;

import java.util.Comparator;
import java.util.List;

import com.example.colors.customer.Customer;

/**
 * This class gives inplementation for Rule class, this class 
 * @author Deepika Vashishtha
 *
 */
public class SortingRule implements Rule {
	private Rule nextRule;
	private final Comparator<Customer> customerComparator = (c1, c2) -> c1.getRequestedColorsCount().compareTo(c2.getRequestedColorsCount());

	@Override
	public void applyRule(final List<Customer> customers) {
		customers.sort(customerComparator);
		if (nextRule != null) {
			nextRule.applyRule(customers);
		}
	}

	@Override
	public void setNextRule(final Rule ruleChain) {
		this.nextRule = ruleChain;
	}

}
