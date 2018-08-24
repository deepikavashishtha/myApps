package com.example.colors;

/**
 * This is a builder class for Color and ColorType[which could be Gloss and Matte]
 * @author Deepika Vashishtha
 *
 */
public class ColorMixBuilder {

	private int colorId;
	private ColorType colorType;

	public Color build() {
		if (colorId == 0 || colorType == null) {
			throw new IllegalStateException("Invalid mix config used, Unable to build the color");
		}
		Color color = new Color(colorId);
		color.setColorType(colorType);
		return color;
	}

	public ColorMixBuilder withColorId(final int colorId) {
		this.colorId = colorId;
		return this;
	}
	
	public ColorMixBuilder withType(final ColorType colorType) {
		this.colorType = colorType;
		return this;
	}
}
