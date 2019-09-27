package code;

import java.util.LinkedList;
import java.util.List;

import interfaces.Ant;
import interfaces.Field;
import interfaces.Food;

public class SimpleField implements Field {

	List<Food> registeredFoods = new LinkedList<>();
	List<Ant> registeredAnts = new LinkedList<>();
	int xSize, ySize;
	
	public SimpleField(int xSize,int ySize){
		if(xSize<1 || ySize<1)
			throw new IllegalArgumentException("Size cannot be smaller than 1");
		this.xSize=xSize;
		this.ySize=ySize;
	}
	
	public List<Ant> getAllAnts() {
		return registeredAnts;
	}

	public List<Food> getAllFood() {
		return registeredFoods;
	}

	public void registerAnt(Ant toRegister) {
		registeredAnts.add(toRegister);
	}

	public void update() {
		registeredFoods.removeIf(x -> x.getNutritionValue()<=0);
	}

}
