
public class MockMap implements Map {

	public List<Ant> antsToReturn;
	public List<Food> foodToReturn;
	public Ant registeredAnt;
	
	
		
	@Override
	public List<Ant> getAllAnts() {
		return null;
	}

	@Override
	public List<Food> getAllFood() {
		return null;
	}

	@Override
	public void registerAnt(Ant ToRegister) {
		registeredAnt = ToRegister;
	}

	@Override
	public void update() {
		
	}

}
