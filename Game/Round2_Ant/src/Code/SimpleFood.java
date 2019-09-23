package Code;

import java.awt.Point;

public class SimpleFood implements Food {


	public String name;
	private Point point;
	public int nutritionValue =  0;
	
	public SimpleFood(String name, double x, double y, int nutritionValue) {
		if(name != null && name != "")	
			this.name = name;
		else 
			throw new IllegalArgumentException("Name cannot be null or empty!");
		if(x >= 0 && y >= 0)
			this.point.setLocation(x, y);
		else 
			throw new IllegalArgumentException("Location must consist of positive numbers!");
		if(nutritionValue >= 0)
			this.nutritionValue = nutritionValue;
		else 
			throw new IllegalArgumentException("Nutrition Value must be positive");	
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (! (o instanceof Food))
			return false;

		Food foodobject = (Food) o;
		return 
			this.name == foodobject.name 
			&& this.point.x == foodobject.point.x 
			&& this.point.y == foodobject.point.y 
			&& this.nutritionValue == foodobject.nutritionValue;	
	}
	
	public int nibble(int nibble) {
		if (this.nutritionValue >= nibble) {
			this.nutritionValue = this.nutritionValue - nibble;
			return nibble;
		} else {
			this.nutritionValue = 0;
			return nutritionValue;
		}
	}
	
	public Point getPoint() {
		return this.point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	
}
