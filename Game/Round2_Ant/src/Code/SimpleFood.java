package Code;

import java.awt.Point;

public class SimpleFood implements Food {

	public String name;
	private Point point = new Point();
	public int nutritionValue =  0;
	
	public SimpleFood(String name, double x, double y, int nutritionValue) {
	if(name != null && name != "")	
		this.name = name;
	else 
		throw new IllegalArgumentException("Name is null or empty");
	if(x >= 0 && y >= 0)
		this.point.setLocation(x, y);
	else 
		throw new IllegalArgumentException("x or y value of the point is smaler then zero");
	if(nutritionValue >= 0)
		this.nutritionValue = nutritionValue;
	else 
		throw new IllegalArgumentException("nutrition value is smaler then zero");
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof SimpleFood)
		{
			var foodobject = (SimpleFood) o;
			return (this.name == foodobject.name && this.point.x == foodobject.point.x && this.point.y == foodobject.point.y && this.nutritionValue == foodobject.nutritionValue);	
		}
		else
			return false;
	}
	
	@Override
	public int nibble(int nibble) {
	if(this.nutritionValue >= nibble) {
		this.nutritionValue = this.nutritionValue - nibble;
		return nibble;
	}
	else
	{
		this.nutritionValue = 0;
		return nutritionValue;
	}
	}

	@Override
	public Point getPoint() {
		return this.point;
	}

	@Override
	public void setPoint(Point point) {
		this.point = point;
	}
	
}
