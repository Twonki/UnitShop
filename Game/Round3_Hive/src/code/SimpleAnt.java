package code;
import java.awt.Point;

import interfaces.Ant;
import interfaces.Food;

public class SimpleAnt implements Ant {

	public Integer id;
	private Point point;
	private int hungerValue =  0;
	private Food food = null;
	
	public SimpleAnt(Integer id, double x, double y, Food food) {
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
	
	public SimpleAnt(Integer id, double x, double y){
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
		
	}
	
	@Override
	public void pickupFood(Food food) {
		if(this.food != null)
			this.dropFood();
		this.food = food;
	}

	@Override
	public void dropFood() {
		if(this.food != null) {
			Point dropOff = new Point();
			dropOff.setLocation(point.x,point.y);
			
			food.setPoint(dropOff);
			food = null;
		}
	}
	
	@Override
	public void eatFood() {
		if(food!=null) {
			int nibbled = food.nibble(hungerValue);
			hungerValue -= nibbled;
			
			if(food.getNutritionValue()==0)
				dropFood();
		}
	}
	
	public void move(Point point) {
		if(point.x<0 || point.y<0)
			throw new IllegalArgumentException("Point can not be negative");
		this.point = point;
	}
	
	@Override
	public void hungrier() {
		this.hungerValue = this.hungerValue + 1;
	}
	
}
