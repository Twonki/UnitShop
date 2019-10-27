package code;

import java.util.LinkedList;
import java.util.List;

import interfaces.Ant;
import interfaces.Field;
import interfaces.Food;
import logic.Randomizer;

public class SimpleField implements Field {

	List<Food> registeredFoods = new LinkedList<>();
	List<Ant> registeredAnts = new LinkedList<>();
	int xSize, ySize;
	Randomizer rnd;
	
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

		
		double per = Math.random();
		double thresh = 1- ((double)(registeredAnts.size()))/100; 
		// Creates new food on the map
		// Creates with 99% if we have one ant, with 0% when we have 100
		if (per<thresh ) {
			registeredFoods.add(rnd.getRandomFood());
		}
	}

	public void setRandomizer(Randomizer rnd) {
		this.rnd=rnd;
	}
}
