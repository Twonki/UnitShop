package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Point;
import java.util.List;

import org.junit.jupiter.api.Test;

import code.SimpleFood;
import code.SimpleHive;
import interfaces.Food;

public class HiveTest {
	
	@Test
	void testUpdateMethod_foodGreater100Less200inRange_antCounterGoesUp(){
		throw new UnsupportedOperationException("Not Yet Implemented!");
	}
	
	@Test
	void testConstructor_nameIsNull_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> new SimpleHive(new Point(1,1),null,new MockField()));
	}
	
	@Test
	void testConstructor_nameIsEmpty_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> new SimpleHive(new Point(1,1),"",new MockField()));
	}
	
	@Test
	void testConstructor_xPointIsNegative_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> new SimpleHive(new Point(-1,1),"hive",new MockField()));
	}
	
	@Test
	void testConstructor_yPointIsNegative_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> new SimpleHive(new Point(1,-1),"hive",new MockField()));
	}
	
	@Test
	void testConstructor_fieldIsNull_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> new SimpleHive(new Point(1,1),"Hive",null));
	}
	
	
	
	@Test
	void testUpdate_foodAmountBigger100_shouldCreateNewAnt() {
		MockField testfield = new MockField();
		SimpleHive testhive = new SimpleHive(new Point(2,2),"Hive",testfield);		
	
		int AntCounterBefore = testhive.getAntCounter();
		testhive.setFoodAmount(150);
		testhive.update();
		
		assertTrue(AntCounterBefore < testhive.getAntCounter());
	}
}
