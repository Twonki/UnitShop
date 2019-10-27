package interfaces;

import java.awt.Point;

public interface Food {

	int nibble(int nibble);
	
	Point getPoint();
	void setPoint(Point point);

	int getNutritionValue();

}