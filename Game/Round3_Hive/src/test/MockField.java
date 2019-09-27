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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> getAllFood() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerAnt(Ant ToRegister) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
