package Code;

import java.awt.Point;

public class Food {

	public String name;
	private Point point;
	public int nutritionValue;
	
	public Food(String name, double x, double y, int nutritionValue) {
		//TO DO
	}
	
	@Override
	public boolean equals(Object o) {
		//TO DO
	}
	
	public int nibble(int nibble) {
		//TO DO
	}
	
	public Point getPoint() {
		return this.point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	
	//This is how to throw an exception
	public void howToThrowException() {
		throw new NullPointerException("demo");
		throw new IllegalArgumentException("Point can not be negative");
	}
}
