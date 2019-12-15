package code;

import java.awt.Point;
import interfaces.Ant;
import interfaces.Field;
import interfaces.Hive;

public class SimpleHive implements Hive {

	Point position;
	String name;
	Field field;
	
	int foodAmount, antCounter;
	
	final int range = 3;
	
	
	public SimpleHive(Point position, String name, Field field) {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	
	public void update() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	private void absorbNearbyFood() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public Point getPosition() {
		return position;
	}

	
	public int getFoodAmount() {
		return foodAmount;
	}

	
	public String getName() {
		return name;
	}


	public Field getField() {
		return field;
	}
	
	public void setFoodAmount(int amount) {
		this.foodAmount = amount;
	}
	
	public int getAntCounter() {
		return antCounter;
	}
}