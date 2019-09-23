package Code;
import java.awt.Point;

public class Ant {

	public Integer id;
	public Point point = new Point();
	public int hungerValue =  0;
	public SimpleFood food = null;
	
	public Ant(Integer id, double x, double y, Integer hunger, SimpleFood food) {
	if(id >= 0)
		this.id = id;
	else
		throw new IllegalArgumentException("Dumbazz");
	if(x >= 0 && y >= 0)
		this.point.setLocation(x,y);
	else
		throw new IllegalArgumentException("Dumbazz");
	if(hunger >= 0)
		this.hungerValue = hunger;
	else
		throw new IllegalArgumentException("Dumbazz");
	if(food != null)
	this.food = food;
	}
	
	public void pickupFood(SimpleFood food) {
	if(this.food != null)
		this.dropFood();
		this.food = food;
	}

	public void dropFood() {
	if(this.food != null) {
		this.food.getPoint().x = this.point.x;
		this.food.getPoint().y = this.point.y;
		this.food = null;}
	else {}
	}
	
	public int eatFood(int nibble) {
	if(this.food != null) {
			this.food.nibble(nibble);
			if(this.food.nutritionValue <= 0)
				this.dropFood();
			if(this.hungerValue > nibble) {
				this.hungerValue = this.hungerValue - nibble;
				return nibble;
			}
			else {
				this.hungerValue = 0;
				return nibble;
			}
	}
	else {return nibble;}
	}
	
	
	public void move(Point point) {
		this.point = point;
	}
	
	public void hungrier() {
		this.hungerValue = this.hungerValue + 1;
	}
	
}
