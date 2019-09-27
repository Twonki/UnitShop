package logic;

import interfaces.Field;
import interfaces.Hive;

public class HiveMind {
	
	Field field;
	Randomizer rnd;
	Hive hive;
	
	public HiveMind (Field field, Randomizer rnd, Hive hive) {
		this.field=field;
		this.rnd=rnd;
		this.hive=hive;
	}
	
	
}
