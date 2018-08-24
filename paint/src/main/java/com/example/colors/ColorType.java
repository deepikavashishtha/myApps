package com.example.colors;

/**
 * This is an enum class for Color Type
 * @author Deepika Vashishtha
 *
 */
public enum ColorType {
	GLOSS("G"),
	MATTE("M");
	
	private final String symbol;

	ColorType(final String symbol) {
		this.symbol = symbol;
	}
	public static ColorType getColorType(final String symbol) {
		switch (symbol) {
		case "G":
			return GLOSS;
		case "M":
			return MATTE;
		default:
			throw new IllegalArgumentException("Invalid color type symbol passed");
		}
	}

	public String getSymbol() {
		return symbol;
	}
}
