package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import org.junit.jupiter.api.Test;

import Code.Food;

public class FoodTest {
	
	
	//sample test to show basic functions and how to setup a test in general
	@Test
	void testSomething_InputIsFalse_ShouldThrowException() {
		Food testobject = new Food("testfood",1,1,50);
		Food testobject1 = new Food("testfood",1,1,50);
		assertTrue(testobject.name == "testfood");
		assertThrows(IllegalArgumentException.class, () -> new Food(null,1,1,100));
		assertFalse(testobject.equals(testobject1));
		assertEquals(40,testobject.nutritionValue);
	}
	
}
