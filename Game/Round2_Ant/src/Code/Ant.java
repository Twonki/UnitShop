package Code;
import java.awt.Point;

public class Ant {

	public Integer id;
	public Point point;
	public int hungerValue =  0;
	public Food food;
	
	public Ant(Integer id, double x, double y, Food food) {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	public void pickupFood(Food food) {
		if(this.food != null)
			this.dropFood();
		this.food = food;
	}

	public void dropFood() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	public void eatFood() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	public void move(Point point) {
		if(point.x<0 || point.y<0)
			throw new IllegalArgumentException("Point can not be negative");
		this.point = point;
	}
	
	public void hungrier() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
}
