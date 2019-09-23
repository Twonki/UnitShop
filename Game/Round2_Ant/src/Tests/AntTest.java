package Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import Code.Ant;
import Code.FakeFood;

public class AntTest {

	@Test
	void testConstructor_allValuesAreOK_shouldBeBuildwithSetValues() {
		FakeFood testfood = new FakeFood();
		
		Ant testant = new Ant(1,2,2,testfood);
		
		assertTrue(testant.id == 1);
		assertTrue(testant.point.x == 2);
		assertTrue(testant.point.y == 2);
		assertTrue(testant.hungerValue == 0);
		assertTrue(testant.food.equals(testfood));
	}
	
	@Test
	void testConstructor_IdIsNegative_shouldThrowException() {
		FakeFood testfood = new FakeFood();
		assertThrows(IllegalArgumentException.class, () -> new Ant(-1,1,1,testfood));
	}

	@Test
	void testConstructor_xPointIsNegative_shouldThrowException() {
		FakeFood testfood = new FakeFood();
		assertThrows(IllegalArgumentException.class, () -> new Ant(1,-1,1,testfood));
	}
	
	@Test
	void testConstructor_yPointIsNegative_shouldThrowException() {
		FakeFood testfood = new FakeFood();
		assertThrows(IllegalArgumentException.class, () -> new Ant(1,1,-1,testfood));
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
		FakeFood testfood = new FakeFood();
		Ant testant = new Ant(1,2,2,testfood);
		
		testant.pickupFood(testfood);
		testant.dropFood();
		
		assertTrue(testant.food == null);
	}
	
	@Test
	void testDropFood_DropFood_FoodShouldInvokeSetPosition() {
		FakeFood testfood = new FakeFood();
		Ant testant = new Ant(1,2,2,testfood);
		
		testant.pickupFood(testfood);
		testant.dropFood();
		
		assertTrue(testfood.setPointInput!=null);
	}
	
	@Test
	void testEatFood_NibbleOnFood_hungerValueReducedByAmount() {
		FakeFood testfood = new FakeFood();
		testfood.nibbleReturnValue=2;
		
		Ant testant = new Ant(1,2,2,testfood);
		
		// Make the hungervalue of ant 2
		testant.hungrier();
		testant.hungrier();
		
		testant.eatFood();
		
		assertEquals(0,testant.hungerValue);
	}
	
	
	@Test
	void testMove_MoveFood_FoodShouldBeMovedToNewPoint() {
		Point testpoint = new Point(3,3);
		FakeFood testfood = new FakeFood();
		Ant testant = new Ant(1,2,2,testfood);
		testant.move(testpoint);
		assertEquals(testant.point,testpoint);
	}
	
	@Test
	void testHungrier_callMethod_HungerValueShouldBeIncreased() {
		FakeFood testfood = new FakeFood();
		Ant testant = new Ant(1,2,2,testfood);
		
		testant.hungrier();
		
		assertEquals(1,testant.hungerValue);
	}
	
	//ok to use other functions which are already tested like drop food in here?
	@Test
	void testDropFood_ifAntHasNoFoodToDrop_NothingShouldHappen() {
		Ant testant = new Ant(1,2,2,null);
		
		testant.dropFood();
		return;
	}
	
	@Test
	void testEatFood_ifAntHasNoFoodToEat_NothingShouldHappen() {
		Ant testant = new Ant(1,2,2,null);
		testant.hungrier();
		
		testant.eatFood();
		
		assertEquals(1,testant.hungerValue);
	}
	
	@Test
	void testEatFood_reducesNutritionToZero_foodShouldBeDropped() {
		FakeFood testfood = new FakeFood();
		Ant testant = new Ant(1,2,2,testfood);
		testant.eatFood();
		assertNull(testant.food);
	}
	
	@Test
	void testPickUpFood_ifAntHasFood_OldFoodShouldBeDropped() {
		FakeFood testfood = new FakeFood();
		FakeFood testfood2 = new FakeFood();
		
		Ant testant = new Ant(1,2,2,testfood);
		
		testant.pickupFood(testfood2);
		
		assertTrue(testfood.setPointInput!=null);
	}
	
	@Test
	void testPickUpFood_ifAntHasFood_NewFoodShouldBeHeld() {
		FakeFood oldFood = new FakeFood();
		FakeFood newFood = new FakeFood();
		Ant testant = new Ant(1,2,2,oldFood);
		
		testant.pickupFood(newFood);
		
		assertTrue(testant.food == newFood);
	}
}

