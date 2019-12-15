package test;
import java.util.ArrayList;
import java.util.List;

import interfaces.Ant;
import interfaces.Field;
import interfaces.Food;


public class MockField implements Field {

	public List<Ant> antsToReturn = new ArrayList<Ant>();
	public List<Food> foodToReturn = new ArrayList<Food>();
	public Ant registeredAnt;
	
	@Override
	public List<Ant> getAllAnts() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public List<Food> getAllFood() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void registerAnt(Ant ToRegister) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void update() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

}
