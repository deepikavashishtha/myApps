package com.example.colors.rules;

import java.util.List;

import com.example.colors.customer.Customer;

/**
 * @author Deepika Vashishtha
 *
 */
public interface Rule {
	void applyRule(List<Customer> customers);

	void setNextRule(Rule ruleChain);
}
