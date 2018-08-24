package com.example.colors;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.example.colors.customer.Customer;

/**
 * This class represents pool for color batch. It has a hashmap, which maintains colors to be present in final batch. This is a singleton class.
 * @author Deepika Vashishtha
 *
 */
public class ColorBatchPool {
	private Map<Integer, ColorType> finalColors;

	private static ColorBatchPool INSTANCE = new ColorBatchPool();

	private ColorBatchPool() {
		// private constructor
	}

	public static ColorBatchPool instance() {
		return INSTANCE;
	}

	public void addColor(int id, ColorType colorType) {
		finalColors.put(id, colorType);
	}


	public void setup(String count) {
		finalColors = new TreeMap<Integer, ColorType>();
	}

	public Color processCustomerOrder(Customer customer, List<Color> possibleColors) {

		for (Map.Entry<Integer, ColorType> entry : customer.getRequestedColors().entrySet()) {
			int color = entry.getKey();
			ColorType requestedType = entry.getValue();
			final ColorType finalColorType = finalColors.get(color);

			if (customer.getRequestedColorsCount() == 1) {
				if (finalColorType == null || finalColorType.equals(requestedType)) {
					// there is no finish fixed for this color yet,
					// or it's the same as the preference of this customer
					return new ColorMixBuilder().withColorId(color).withType(requestedType).build();
				} else {
					// there is another finish needed for this color already,
					// there is no solution.
					return null;
				}
			} else {
				if (finalColorType == null) {
					// 'color' is not in the final type yet, so keep it as a possible colors
					possibleColors.add(new ColorMixBuilder().withColorId(color).withType(requestedType).build());
				} else if (finalColorType.equals(requestedType)) {
					// we found one of the color preferences of this customer in the already finalized colors, let's return it!
					return new ColorMixBuilder().withColorId(color).withType(requestedType).build();
				}
			}
		}

		// for a customer with multiple color preferences, there were no match 
		// in the already fixed paints; that's not a problem.
		return null;
	}

	public Map<Integer, ColorType> getColorPool() {
		return finalColors;
	}
}
