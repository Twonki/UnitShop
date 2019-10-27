package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Point;
import org.junit.jupiter.api.Test;

import Code.SimpleFood;

public class FoodTest {
	
	@Test
	void testConstructor_allValuesAreOk_shouldBeBuildWithSetValues() {
		SimpleFood testobject = new SimpleFood("testfood",1,1,50);
		assertTrue(testobject.name == "testfood");
		assertTrue(testobject.getPoint().x == 1);
		assertTrue(testobject.getPoint().y == 1);
		assertTrue(testobject.getNutritionValue() == 50);
	}
	
	@Test
	void testConstructor_nameIsNull_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> new SimpleFood(null,1,1,100));
	}
	
	@Test
	void testConstructor_nameIsEmpty_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> new SimpleFood("",1,1,100));
	}
	
	@Test
	void testConstructor_xPointIsNegative_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> new SimpleFood("test",-1,1,100));
	}
	
	@Test
	void testConstructor_yPointIsNegative_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> new SimpleFood("test",1,-1,100));
	}
	
	@Test
	void testConstructor_nutritionValueIsNegative_shouldThrowException() {
			assertThrows(IllegalArgumentException.class, () -> new SimpleFood("test",1,1,-10));
	}
	
	@Test
	void testEquals_sameObject_shouldBeEqualToItself_shouldBeTrue() {
		SimpleFood testobject = new SimpleFood("testfood",1,1,1);

		assertTrue(testobject.equals(testobject));
	}

	@Test
	void testEquals_sameObjects_shouldBeEqual_shouldBeTrue() {
		SimpleFood testobject1 = new SimpleFood("testfood",1,1,1);
		SimpleFood testobject2 = new SimpleFood("testfood",1,1,1);

		assertTrue(testobject1.equals(testobject2));
	}
	
	@Test
	void testEquals_sameNameDifferentPositionandNutritionvalue_shouldBeFalse() {
		SimpleFood testobject1 = new SimpleFood("testfood",2,2,2);
		SimpleFood testobject2 = new SimpleFood("testfood",1,1,1);

		assertFalse(testobject1.equals(testobject2));
	}
	
	@Test
	void testEquals_sameNameAndPositionDifferentNutritionvalue_shouldBeFalse() {
		SimpleFood testobject1 = new SimpleFood("testfood",1,1,2);
		SimpleFood testobject2 = new SimpleFood("testfood",1,1,1);

		assertFalse(testobject1.equals(testobject2));
	}
	
	@Test
	void testEquals_sameNameAndNutritionvalueDifferentPosition_shouldBeFalse() {
		SimpleFood testobject1 = new SimpleFood("testfood",2,2,1);
		SimpleFood testobject2 = new SimpleFood("testfood",1,1,1);

		assertFalse(testobject1.equals(testobject2));
	}
	
	@Test
	void testEquals_samePositionDifferentNameAndNutritionvalue_shouldBeFalse() {
		SimpleFood testobject1 = new SimpleFood("testfood",1,1,2);
		SimpleFood testobject2 = new SimpleFood("testfood1",1,1,1);

		assertFalse(testobject1.equals(testobject2));
	}
	
	@Test
	void testEquals_samePositionAndNutritionvalueDifferentName_shouldBeFalse() {
		SimpleFood testobject1 = new SimpleFood("testfood",1,1,1);
		SimpleFood testobject2 = new SimpleFood("testfood1",1,1,1);

		assertFalse(testobject1.equals(testobject2));
	}
	
	@Test
	void testEquals_sameNutritionValueDifferentPositionAndName_shouldBeFalse() {
		SimpleFood testobject1 = new SimpleFood("testfood",1,1,1);
		SimpleFood testobject2 = new SimpleFood("testfood1",2,2,1);

		assertFalse(testobject1.equals(testobject2));
	}
	
	@Test
	void testEquals_DifferentNameAndPositionAndNutritionValue_shouldBeFalse() {
		SimpleFood testobject1 = new SimpleFood("testfood",2,2,2);
		SimpleFood testobject2 = new SimpleFood("testfood1",1,1,1);

		assertFalse(testobject1.equals(testobject2));
	}
	
	@Test
	void testEquals_compareToObjectOfDifferentClass_shouldBeFalse_shouldBeFalse() {
		SimpleFood testobject1 = new SimpleFood("testfood",2,2,2);
		Point testobject2 = new Point(1,1);

		assertFalse(testobject1.equals(testobject2));
	}
	
	
	//How to make this dynamic
	@Test
	void testNibble_inputIsNumberSmallerThanNutrition_shouldReturnFullNibbleAmount() {
		SimpleFood testobject = new SimpleFood("doesntmatter",0,0,50);
		
		int result = testobject.nibble(10);
		
		assertEquals(10,result);
	}
	
	void testNibble_inputIsSmallerThanNutritionValue_NutritionValueShouldBeReducedByNibbleAMount() {
		SimpleFood testobject = new SimpleFood("doesntmatter",0,0,50);
		
		testobject.nibble(10);
		
		assertEquals(40,testobject.getNutritionValue());
	};
	
	@Test
	void testNibble_inputIsNumberBiggerThanNutrition_shouldReturnNutritionEqualsZero() {
		SimpleFood testobject = new SimpleFood("testfooo",1,1,50);
		
		testobject.nibble(60);
		
		assertEquals(0,testobject.getNutritionValue());
	}
	
	@Test
	void testGetPoint_returnPoint_shouldReturnFoodObjectPoint()
	{
		SimpleFood testobject = new SimpleFood("testfooo",1,1,50);
		Point testpoint = new Point(1,1);
		
		assertTrue(testpoint.x == testobject.getPoint().getX() && testpoint.y == testobject.getPoint().y);
	}
	
	@Test
	void testSetPoint_setPointToValue_pointShouldGetSetValues()	{
		SimpleFood testobject = new SimpleFood("testfooo",1,1,50);
		Point testpoint = new Point(2,2);
		testobject.setPoint(testpoint);
		
		assertTrue(testobject.getPoint().x == 2 && testobject.getPoint().y == 2);
	}
	
}
