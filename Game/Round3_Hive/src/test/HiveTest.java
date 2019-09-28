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
	void testConstructor_allValuesAreOK_shouldBeBuildwithSetValues() {
		MockField testfield = new MockField();
		SimpleHive testhive = new SimpleHive(new Point(2,2),"Hive",testfield);

		assertTrue(testhive.getName() == "Hive");
		assertEquals(testhive.getPosition(),new Point(2,2));
		assertEquals(testhive.getField(),testfield);
		assertTrue(testhive.getFoodAmount() == 0);
	}
	
	/*
	@Test
	void testUpdateMethod_foodGreater100Less200inRange_antCounterGoesUp(){
		MockField testfield = new MockField();
		SimpleHive testhive = new SimpleHive(new Point(2,2),"Hive",testfield);
		int antCountBefore = testhive.getAntCounter();
		testfield.wantedFoodAmount = 150;
		testfield.foodInRange = true;
		testhive.update();
		assertEquals(antCountBefore + 1, testhive.getAntCounter());
	}
	*/
	
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
	void testAbsorbNearbyfood_foodInRange_shouldBeNibbled() {
		MockField testfield = new MockField();
		SimpleHive testhive = new SimpleHive(new Point(2,2),"Hive",testfield);
		FakeFood foodInRange = new FakeFood();
		
		foodInRange.setPoint(new Point(3,3));
		testfield.foodToReturn.add(foodInRange);
		testhive.update();
		testfield.getAllFood();
		
		assertTrue(foodInRange.hasBeenNibbled);
	}
	
	@Test
	void testAbsorbNearbyfood_foodNotInRange_shouldNotBeNibbled() {
		MockField testfield = new MockField();
		SimpleHive testhive = new SimpleHive(new Point(2,2),"Hive",testfield);
		FakeFood foodNotInRange = new FakeFood();
		
		foodNotInRange.setPoint(new Point(3,3));
		testfield.foodToReturn.add(foodNotInRange);
		testhive.update();
		
		assertFalse(foodNotInRange.hasBeenNibbled);
	}
		
}
