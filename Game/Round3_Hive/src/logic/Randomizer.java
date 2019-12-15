package logic;

import java.awt.Point;

import code.SimpleFood;
import interfaces.Food;

public class Randomizer {
	
	int xSize = 0, ySize = 0;
	
	public Randomizer(int xSize,int ySize) {
		if (xSize>0 && ySize > 0) {
			this.xSize = xSize;
			this.ySize = ySize;
		}
	}
	
	public Point getRandomValidPoint() {
		int x = (int)(Math.random()*xSize);
		int y = (int)(Math.random()*ySize);
		return new Point (x,y);
	}

	public Food getRandomFood() {
		var p = getRandomValidPoint();
		
		double randomValue = Math.random();
		
		if(randomValue<0.6) {
			return new SimpleFood("Berry",p.getX(),p.getY(),10);
		} else if (randomValue<90) {
			return new SimpleFood("Honey",p.getX(),p.getY(),30);
		} else {
			return new SimpleFood("Sugar",p.getX(),p.getY(),50);
		}
		
	}
}
