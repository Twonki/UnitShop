
public interface Map {

	public List<Ant> getAllAnts();
	public List<Food> getAllFood();
	
	public void registerAnt(Ant ToRegister);
	
	public void update();
	
}
