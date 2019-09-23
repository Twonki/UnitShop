package Code;

import java.awt.Point;

public class Food {

	public String name;
	public Point point = new Point();
	public int nutritionValue =  0;
	
	public Food(String name, double x, double y, int nutritionValue) {
	if(name != null && name != "")	
		this.name = name;
	else 
		throw new IllegalArgumentException("You are Screwed");
	if(x >= 0 && y >= 0)
		this.point.setLocation(x, y);
	else 
		throw new IllegalArgumentException("You are Screwed");
	if(nutritionValue >= 0)
		this.nutritionValue = nutritionValue;
	else 
		throw new IllegalArgumentException("You are Screwed");
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Food)
		{
			var foodobject = (Food) o;
			return (this.name == foodobject.name && this.point.x == foodobject.point.x && this.point.y == foodobject.point.y && this.nutritionValue == foodobject.nutritionValue);	
		}
		else
			return false;
	}
	
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
}
