package Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import Code.Ant;
import Code.FakeFood;

public class AntTest {

	@Test
	void testConstructor_yPointIsNegative_shouldThrowException() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	@Test
	void testPickUpFood_FoodValueIsOk_shouldBeBuildWithSetValues() {
		FakeFood testfood = new FakeFood();
		Ant testant = new Ant(1,2,2,testfood);
		testant.pickupFood(testfood);
		assertTrue(testant.food.equals(testfood));
	}
	
	@Test
	void testDropFood_DropFood_shouldBeDroppedAndSetToNull() {		
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	@Test
	void testDropFood_DropFood_FoodShouldInvokeSetPosition() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
}