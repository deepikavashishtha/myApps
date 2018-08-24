package com.example.colors.customer;

import java.util.Map;

import com.example.colors.Color;
import com.example.colors.ColorType;

public class Customer {
	private Color grantedColor;

	private final Map<Integer, ColorType> colorsRequested;

	public Customer(final Map<Integer, ColorType> colorsOrdered) {
		this.colorsRequested = colorsOrdered;
	}

	public Integer getRequestedColorsCount() {
		return colorsRequested.size();
	}

	public Map<Integer, ColorType> getRequestedColors() {
		return colorsRequested;
	}

	public Color getGrantedColor() {
		return grantedColor;
	}
}
