package test;
import java.util.List;

import interfaces.Ant;
import interfaces.Field;
import interfaces.Food;


public class MockField implements Field {

	public List<Ant> antsToReturn;
	public List<Food> foodToReturn;
	public Ant registeredAnt;
	
	@Override
	public List<Ant> getAllAnts() {
		return antsToReturn;
	}

	@Override
	public List<Food> getAllFood() {
		return foodToReturn;
	}

	@Override
	public void registerAnt(Ant ToRegister) {
		// TODO Auto-generated method stub
		antsToReturn.add(ToRegister);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

}
