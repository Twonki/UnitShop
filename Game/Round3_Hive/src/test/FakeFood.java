package test;

import java.awt.Point;

public class FakeFood implements Food {

	public boolean hasBeenNibbled = false;
	public int nibbleReturnValue;
	public int nibbleInputValue;
	
	public Point setPointInput;
	
	public int nutritionReturnValue;
	
	public int nibble(int nibble) {
		nibbleInputValue = nibble;
		hasBeenNibbled = true;
		return nibbleReturnValue;
	}

	public Point getPoint() {
		return null;
	}

	public void setPoint(Point point) {
		setPointInput = point;
	}

	public int getNutritionValue() {
		return nutritionReturnValue;
	}

}
