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
		this.position=position;
		this.name = name;
		this.field = field;
		foodAmount = 0;
	}
	
	
	public void update() {
		absorbNearbyFood();
		if(foodAmount > 100) {
			Ant toAdd = new SimpleAnt(antCounter,(int)getPosition().x,(int)getPosition().y);
			antCounter ++;
			field.registerAnt(toAdd);
		}
	}

	private void absorbNearbyFood() {
		field.getAllFood()
			.stream()
			.filter(food -> food.getPoint().distance(getPosition()) <= range)
			.map(food -> food.nibble(Integer.MAX_VALUE))
			.reduce((acc,x) -> acc + x)
			.ifPresent(x -> foodAmount += x);
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
	

}
