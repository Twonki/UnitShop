package Code;

import java.awt.Point;

public class FakeFood implements Food {

	public boolean hasBeenNibbled = false;
	public int nibbleReturnValue;
	public int nibbleInputValue;
	public Point setPointInput;
	
	@Override
	public int nibble(int nibble) {
		nibbleInputValue = nibble;
		hasBeenNibbled = true;
		return nibbleReturnValue;
	}

	@Override
	public Point getPoint() {
		return null;
	}

	@Override
	public void setPoint(Point point) {
		setPointInput = point;
	}

}
