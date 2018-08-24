package com.example.colors;

/**
 * This class represents Color. It holds properties of color.
 * @author Deepika Vashishtha
 *
 */
public class Color {
	private final int colorId;
	private ColorType colorType;
	
	private boolean canChange = true;

	public Color(final int colorId) {
		this.colorId = colorId;
	}

	public ColorType getColorType() {
		return colorType;
	}

	public void setColorType(ColorType colorType) {
		this.colorType = colorType;
	}

	public int getColorId() {
		return colorId;
	}

	public boolean canChange() {
		return canChange;
	}

	public void dontAllowChange() {
		canChange = false;
	}

	public boolean isTypeDifferent(final Color otherColor) {
		return (this.colorType != otherColor.colorType);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + colorId;
		result = prime * result + ((colorType == null) ? 0 : colorType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Color other = (Color) obj;
		if (colorId != other.colorId)
			return false;
		if (colorType != other.colorType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Color [colorId=" + colorId + ", colorType=" + colorType + "]";
	}

}
