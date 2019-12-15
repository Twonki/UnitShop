package logic;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import interfaces.Ant;
import interfaces.Field;
import interfaces.Food;
import interfaces.Hive;

public class HiveMind {
	
	Field field;
	Randomizer rnd;
	Hive hive;
	
	Map<Integer,Food> antMapping = new HashMap<>(); 
	
	public HiveMind (Field field, Randomizer rnd, Hive hive) {
		this.field=field;
		this.rnd=rnd;
		this.hive=hive;
	}

	public void update() {
		assignFreeAnts();
		pickupFoodIfAble();
		moveAnts();
		dropFoodIfAble();
		deAssignAnts();
	}
	
	 
	private void dropFoodIfAble() {
		field.getAllAnts().stream()
			.filter(x->x.hasFood())
			.filter(x -> x.getPosition().equals(hive.getPosition()))
			.forEach(ant -> ant.dropFood());
	}

	private void moveAnts() {
		moveFoodSearchingAnts();
		moveFoodCarryingAnts();
	}

	private void moveFoodSearchingAnts() {
		antMapping.entrySet().stream()
		.map(kv -> new Tuple<Optional<Ant>,Food>(lookupAntID(kv.getKey()), kv.getValue()))
		.filter(kv -> kv.x.isPresent())
		.map(kv -> new Tuple<Ant,Food>(kv.x.get(),kv.y))
		.forEach(kv -> kv.x.move(kv.y.getPoint()));
	}

	private void moveFoodCarryingAnts() {
		field.getAllAnts().parallelStream()
			.filter( ant -> ant.hasFood())
			.forEach(ant -> moveTowards(ant,hive.getPosition(),4));
	}

	private void moveTowards(Ant a, Point position, int stepSize) {
		a.hungrier();
		a.eatFood();
		
		if(a.getPosition().distance(position)<stepSize)
			a.move(position);
		else {
			Integer[] dirs = {-4,-3,-2,-1,0,1,2,3,4};
			List<Integer> listDirs = Arrays.asList(dirs);
			
			Optional<Point> posMove = 
					listDirs.stream()
					.flatMap(x -> listDirs.stream().map(y -> new Tuple<Integer,Integer>(x,y)))
					.map(xy -> new Point((int)position.getX()+xy.x, (int)position.getY()+xy.y))
					.filter(p -> p.distance(position)<stepSize)
					.sorted((p1,p2) -> (int) p1.distance(position) - (int) p2.distance(position))
					.findFirst();
			
			posMove.ifPresent(pos -> a.move(pos));
			}
	}

	private void assignFreeAnts() {
		field.getAllAnts().stream()
				.filter( ant -> ! ant.hasFood())
				.filter(ant -> ! antMapping.containsKey(ant.getId()))
				.forEach(ant -> getClosestFreeFood(ant.getPosition()).ifPresent( food -> antMapping.put(ant.getId(),food)));
	}
	
	
	private void pickupFoodIfAble() {
		antMapping.entrySet().stream()
			.map(kv -> new Tuple<Optional<Ant>,Food>(lookupAntID(kv.getKey()), kv.getValue()))
			.filter(kv -> kv.x.isPresent())
			.map(kv -> new Tuple<Ant,Food>(kv.x.get(),kv.y))
			.forEach(kv -> kv.x.pickupFood(kv.y));
	}
	
	// Looks up Ants in the list which have found their food
	private void deAssignAnts() {
		antMapping = antMapping.entrySet()
			.stream()
			.map(x-> lookupAntID(x.getKey()))
			.filter(maybeAnt -> maybeAnt.isPresent())
			.map(maybeAnt -> maybeAnt.get())
			.filter(ant-> ! ant.hasFood())
			.collect(Collectors.toMap( Ant::getId, x -> antMapping.get(x.getId())));
	}
	
	private Optional<Food> getClosestFreeFood(Point p) {
		return field.getAllFood().stream()
			.filter(x-> ! antMapping.values().contains(x))
			.sorted((x,y)-> (int) p.distance(x.getPoint()) - (int)p.distance(y.getPoint()))
			.findFirst();
	}
	
	private Optional<Ant> lookupAntID(Integer id) {
		return field.getAllAnts()
			.stream()
			.filter(ant -> ant.getId() == id)
			.findFirst();
	}
	

	private class Tuple<X, Y> { 
		  public final X x; 
		  public final Y y; 
		  public Tuple(X x, Y y) { 
		    this.x = x; 
		    this.y = y; 
		  } 
	} 
}

