package logic;

import java.awt.Point;

import code.SimpleAnt;
import code.SimpleField;
import code.SimpleHive;
import interfaces.Ant;
import interfaces.Hive;

public class App {

	public static void main(String[] args) {
		System.out.println("Starting App");
		int rounds = 0;
		SimpleField field = new SimpleField(100,100);
		Randomizer rnd = new Randomizer(100,100);
		
		field.setRandomizer(rnd);
		
		Hive hive = new SimpleHive(rnd.getRandomValidPoint(),"Alphas",field);
		
		HiveMind swarm = new HiveMind(field,rnd,hive);
		
		Point testAntPoint1 = rnd.getRandomValidPoint();
		Ant testAnt1 = new SimpleAnt(1000, testAntPoint1.x, testAntPoint1.y);
		field.registerAnt(testAnt1);
		
		Point testAntPoint2 = rnd.getRandomValidPoint();
		Ant testAnt2 = new SimpleAnt(1001, testAntPoint2.x, testAntPoint2.y);
		field.registerAnt(testAnt2);
		
		Point testAntPoint3 = rnd.getRandomValidPoint();
		Ant testAnt3 = new SimpleAnt(1002, testAntPoint3.x, testAntPoint3.y);
		field.registerAnt(testAnt3);
		
		
		while(field.getAllAnts().size()<100 && rounds < 10000) {
			// Clears all Empty Foods
			// Spawns new food randomly
			field.update();
			// Moves ants without food to food
			// Moves ants with food to hive
			swarm.update();
			// Eats food around it and makes ants
			hive.update();
			
			rounds ++;
			
			System.out.println("Round " + rounds + ": Ants - " + field.getAllAnts().size() + " Foods - " + field.getAllFood().size());
		}
			
		
		System.out.println("Reached a hundred ants!");
		System.out.println("Closing Application");
	}

}
