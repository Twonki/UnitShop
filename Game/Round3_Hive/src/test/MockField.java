package test;
import java.util.List;

import interfaces.Ant;
import interfaces.Field;
import interfaces.Food;

public class MockField implements Field {

	public List<SimpleAnt> antsToReturn;
	public List<Food> foodToReturn;
	public SimpleAnt registeredAnt;

	@Override
	public List<SimpleAnt> getAllAnts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> getAllFood() {
		// TODO Auto-generated method stub
		return null;
	}

}
