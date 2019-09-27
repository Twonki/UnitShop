package interfaces;

import java.awt.Point;

public interface Ant {

	void pickupFood(Food food);

	void dropFood();

	void eatFood();

	void move(Point point);

	void hungrier();

}