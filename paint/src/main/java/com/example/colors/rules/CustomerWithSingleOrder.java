package com.example.colors.rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.colors.Color;
import com.example.colors.ColorBatchPool;
import com.example.colors.ColorType;
import com.example.colors.customer.Customer;
import com.example.colors.rules.exception.RuleException;

/**
 * This class contains logic for Rule needed to be applied for customers. 
 * @author Deepika Vashishtha
 *
 */
public class CustomerWithSingleOrder implements Rule {
	private Rule nextRule;
	boolean isCustomerHappy = false;

	/* (non-Javadoc)
	 * This class has buisness logic to fits customer requirement for Color batch.
	 * @see com.example.colors.rules.Rule#applyRule(java.util.List)
	 */
	@Override
	public void applyRule(final List<Customer> customers) {
		
		customers.forEach(customer -> {
			if (customer.getRequestedColorsCount() == 1) {
				// Customer has only one color preference, that must be  satisfied.
				final Color orderedResult = ColorBatchPool.instance().processCustomerOrder(customer, Collections.<Color> emptyList());
				if (orderedResult == null) {
					throw new RuleException("Customer not given single choice");
				}
				ColorBatchPool.instance().addColor(orderedResult.getColorId(), orderedResult.getColorType());
			} else {
				List<Color> possibleColors = new ArrayList<>();
				final Color orderedResult = ColorBatchPool.instance().processCustomerOrder(customer, possibleColors);
				if (orderedResult != null) {
					// there is a paint already fixed which is good for this customer,
					// nothing left to do, she is already satisfied
				} else if (possibleColors.isEmpty()) {
					// all the paint preferences of this customer is in conflict
					// with the ones already fixed - no solution exists
					throw new RuleException("All the color preference are conflicting with existing orders");
				} else {
					// Find any possible color is of GLOSS type, if found return first occurence,
					// if no GLOSS color is in the preference then return the first color in the order list.

					Color colorToOrder = possibleColors.stream().filter(c -> c.getColorType() == ColorType.GLOSS).findFirst()
							.orElse(possibleColors.get(0));

					// if a GLOSS color exists in possible colors then add all colors as GLOSS else, all as MATTE
					if (colorToOrder.getColorType() == ColorType.GLOSS) {
						possibleColors.stream().forEach(color -> {
							ColorBatchPool.instance().addColor(color.getColorId(), ColorType.GLOSS);
						});
					} else {
						possibleColors.stream().forEach(color -> {
							ColorBatchPool.instance().addColor(color.getColorId(), ColorType.MATTE);
						});
					}
				}
			}
		});
	}

	@Override
	public void setNextRule(final Rule ruleChain) {
		this.nextRule = ruleChain;
	}
	
}
