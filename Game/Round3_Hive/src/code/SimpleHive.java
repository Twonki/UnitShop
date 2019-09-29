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
	//TO DO
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}
	
	
	public void update() {
		//TO DO
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	private void absorbNearbyFood() {
		//TO DO
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	public Point getPosition() {
		//TO DO
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	
	public int getFoodAmount() {
		//TO DO
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	
	public String getName() {
		//TO DO
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}


	public Field getField() {
		//TO DO
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}
	
	public void setFoodAmount(int amount) {
		//TO DO
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}
	
	public int getAntCounter() {
		//TO DO
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}
}