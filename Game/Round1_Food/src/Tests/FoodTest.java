package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import Code.Food;

public class FoodTest {
	
	@Test
	void testConstructor_allValuesAreOk_shouldBeBuuldwithSetValues() {
		Food testobject = new Food("testfood",1,1,50);
		assertTrue(testobject.name == "testfood");
		assertTrue(testobject.getPoint().x == 1);
		assertTrue(testobject.getPoint().y == 1);
		assertTrue(testobject.nutritionValue == 50);
	}
	
	@Test
	void testConstructor_nameIsNull_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> new Food(null,1,1,100));
	}
	
	@Test
	void testConstructor_nameIsEmpty_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> new Food("",1,1,100));
	}
	
	@Test
	void testConstructor_xPointIsNegative_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> new Food("test",-1,1,100));
	}
	
	@Test
	void testConstructor_yPointIsNegative_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> new Food("test",1,-1,100));
	}
	
	@Test
	void testConstructor_nutritionValueIsNegative_shouldThrowException() {
			assertThrows(IllegalArgumentException.class, () -> new Food("test",1,1,-10));
	}
	
	//Change Task, it looks like only the name has to be equal.
	@Test
	void testEquals_sameObject_shouldBeEqualToItself_shouldBeTrue() {
		Food testobject1 = new Food("testfood",1,1,1);
		Food testobject2 = new Food("testfood",1,1,1);
		assertEquals(true,testobject1.equals(testobject2));
	}
	
	@Test
	void testEquals_sameNameDifferentPositionandNutritionvalue_shouldBeFalse() {
		Food testobject1 = new Food("testfood",2,2,2);
		Food testobject2 = new Food("testfood",1,1,1);
		assertEquals(false,testobject1.equals(testobject2));
	}
	
	@Test
	void testEquals_sameNameAndPositionDifferentNutritionvalue_shouldBeFalse() {
		Food testobject1 = new Food("testfood",1,1,2);
		Food testobject2 = new Food("testfood",1,1,1);
		assertEquals(false,testobject1.equals(testobject2));
	}
	
	@Test
	void testEquals_sameNameAndNutritionvalueDifferentPosition_shouldBeFalse() {
		Food testobject1 = new Food("testfood",2,2,1);
		Food testobject2 = new Food("testfood",1,1,1);
		assertEquals(false,testobject1.equals(testobject2));
	}
	
	@Test
	void testEquals_samePositionDifferentNameAndNutritionvalue_shouldBeFalse() {
		Food testobject1 = new Food("testfood",1,1,2);
		Food testobject2 = new Food("testfood1",1,1,1);
		assertEquals(false,testobject1.equals(testobject2));
	}
	
	@Test
	void testEquals_samePositionAndNutritionvalueDifferentName_shouldBeFalse() {
		Food testobject1 = new Food("testfood",1,1,1);
		Food testobject2 = new Food("testfood1",1,1,1);
		assertEquals(false,testobject1.equals(testobject2));
	}
	
	@Test
	void testEquals_sameNutritionValueDifferentPositionAndName_shouldBeFalse() {
		Food testobject1 = new Food("testfood",1,1,1);
		Food testobject2 = new Food("testfood1",2,2,1);
		assertEquals(false,testobject1.equals(testobject2));
	}
	
	@Test
	void testEquals_DifferentNameAndPositionAndNutritionValue_shouldBeFalse() {
		Food testobject1 = new Food("testfood",2,2,2);
		Food testobject2 = new Food("testfood1",1,1,1);
		assertEquals(false,testobject1.equals(testobject2));
	}
	
	@Test
	void testEquals_compareToObjectOfDifferentClass_shouldBeFalse_shouldBeFalse() {
		Food testobject1 = new Food("testfood",2,2,2);
		Point testobject2 = new Point(1,1);
		assertEquals(false,testobject1.equals(testobject2));
	}
	
	
	//How to make this dynamic
	@Test
	void testNibble_inputIsNumberSmallerThanNutrition_shouldReturnFullNibbleAmount() {
		Food testobject = new Food("doesntmatter",0,0,50);
		
		int result = testobject.nibble(10);
		
		assertEquals(result,10);
	}
	
	void testNibble_inputIsSmallerThanNutritionValue_NutritionValueShouldBeReducedByNibbleAMount() {
		Food testobject = new Food("doesntmatter",0,0,50);
		
		testobject.nibble(10);
		
		assertEquals(40,testobject.nutritionValue);
	};
	
	@Test
	void testNibble_inputIsNumberBiggerThanNutrition_shouldReturnNutritionEqualsZero() {
		Food testobject = new Food("testfooo",1,1,50);
		
		testobject.nibble(60);
		
		assertEquals(0,testobject.nutritionValue);
	}
	
	@Test
	void testGetPoint_returnPoint_shouldReturnFoodObjectPoint()
	{
		Food testobject = new Food("testfooo",1,1,50);
		Point testpoint = new Point(1,1);
		
		assertTrue(testpoint.x == testobject.getPoint().getX() && testpoint.y == testobject.getPoint().y);
	}
	
	@Test
	void testSetPoint_setPointToValue_pointShouldGetSetValues()
	{
		Food testobject = new Food("testfooo",1,1,50);
		Point testpoint = new Point(2,2);
		testobject.setPoint(testpoint);
		
		assertTrue(testobject.getPoint().x == 2 && testobject.getPoint().y == 2);
	}
	
}
