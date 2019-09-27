package interfaces;

import java.awt.Point;

public interface Hive {
	public Point getPosition();

	public int getFoodAmount();
	public String getName();
	
	public void update();
	
	public Field getField();
	
}
