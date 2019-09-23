package Code;
import java.awt.Point;

public class Ant {

	public Integer id;
	public Point point;
	public int hungerValue =  0;
	public Food food = null;
	
	public Ant(Integer id, double x, double y, Food food) {
		if(id >= 0)
			this.id = id;
		else
			throw new IllegalArgumentException("ID cannot be smaller than 0");
		
		if(x >= 0 && y >= 0) {
			point = new Point();
			this.point.setLocation(x,y);
		}
		else
			throw new IllegalArgumentException("Point cannot be negative");
		
		this.food=food;
	}
	
	public void pickupFood(Food food) {
		if(this.food != null)
			this.dropFood();
		this.food = food;
	}

	public void dropFood() {
		if(this.food != null) {
			Point dropOff = new Point();
			dropOff.setLocation(point.x,point.y);
			
			food.setPoint(dropOff);
			food = null;
		}
	}
	
	public void eatFood() {
		if(food!=null) {
			int nibbled = food.nibble(hungerValue);
			hungerValue -= nibbled;
			
			if(food.getNutritionValue()==0)
				dropFood();
		}
	}
	
	public void move(Point point) {
		this.point = point;
	}
	
	public void hungrier() {
		this.hungerValue = this.hungerValue + 1;
	}
	
}
