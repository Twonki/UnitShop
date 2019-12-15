package interfaces;

import java.util.List;

public interface Field {

	public List<Ant> getAllAnts();
	public List<Food> getAllFood();
	
	public void registerAnt(Ant ToRegister);
	
	public void update();
	
}
