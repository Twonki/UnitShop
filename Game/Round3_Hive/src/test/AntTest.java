package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import code.SimpleAnt;

public class AntTest {

	@Test
	void testConstructor_allValuesAreOK_shouldBeBuildwithSetValues() {
		FakeFood testfood = new FakeFood();
		
		SimpleAnt testant = new SimpleAnt(1,2,2,testfood);
		
		assertTrue(testant.getId() == 1);
		assertEquals(testant.getPosition(),new Point(2,2));
		assertTrue(testant.getHungerValue() == 0);
		assertTrue(testant.getFood().equals(testfood));
	}
	
	@Test
	void testConstructor_IdIsNegative_shouldThrowException() {
		FakeFood testfood = new FakeFood();
		assertThrows(IllegalArgumentException.class, () -> new SimpleAnt(-1,1,1,testfood));
	}

	@Test
	void testConstructor_xPointIsNegative_shouldThrowException() {
		FakeFood testfood = new FakeFood();
		assertThrows(IllegalArgumentException.class, () -> new SimpleAnt(1,-1,1,testfood));
	}
	
	@Test
	void testConstructor_yPointIsNegative_shouldThrowException() {
		FakeFood testfood = new FakeFood();
		assertThrows(IllegalArgumentException.class, () -> new SimpleAnt(1,1,-1,testfood));
	}
	
	@Test
	void testPickUpFood_FoodValueIsOk_shouldBeBuildWithSetValues() {
		FakeFood testfood = new FakeFood();
		SimpleAnt testant = new SimpleAnt(1,2,2,testfood);
		testant.pickupFood(testfood);
		assertTrue(testant.getFood().equals(testfood));
	}
	
	@Test
	void testDropFood_DropFood_shouldBeDroppedAndSetToNull() {
		FakeFood testfood = new FakeFood();
		SimpleAnt testant = new SimpleAnt(1,2,2,testfood);
		
		testant.pickupFood(testfood);
		testant.dropFood();
		
		assertTrue(testant.getFood() == null);
	}
	
	@Test
	void testDropFood_DropFood_FoodShouldInvokeSetPosition() {
		FakeFood testfood = new FakeFood();
		SimpleAnt testant = new SimpleAnt(1,2,2,testfood);
		
		testant.pickupFood(testfood);
		testant.dropFood();
		
		assertTrue(testfood.setPointInput!=null);
	}
	
	@Test
	void testEatFood_NibbleOnFood_hungerValueReducedByAmount() {
		FakeFood testfood = new FakeFood();
		testfood.nibbleReturnValue=2;
		
		SimpleAnt testant = new SimpleAnt(1,2,2,testfood);
		
		// Make the hungervalue of ant 2
		testant.hungrier();
		testant.hungrier();
		
		testant.eatFood();
		
		assertEquals(0,testant.getHungerValue());
	}
	
	
	@Test
	void testMove_MoveFood_FoodShouldBeMovedToNewPoint() {
		Point testpoint = new Point(3,3);
		FakeFood testfood = new FakeFood();
		SimpleAnt testant = new SimpleAnt(1,2,2,testfood);
		testant.move(testpoint);
		assertEquals(testant.getPosition(),testpoint);
	}
	
	@Test
	void testHungrier_callMethod_HungerValueShouldBeIncreased() {
		FakeFood testfood = new FakeFood();
		SimpleAnt testant = new SimpleAnt(1,2,2,testfood);
		
		testant.hungrier();
		
		assertEquals(1,testant.getHungerValue());
	}
	
	//ok to use other functions which are already tested like drop food in here?
	@Test
	void testDropFood_ifAntHasNoFoodToDrop_NothingShouldHappen() {
		SimpleAnt testant = new SimpleAnt(1,2,2,null);
		
		testant.dropFood();
		return;
	}
	
	@Test
	void testEatFood_ifAntHasNoFoodToEat_NothingShouldHappen() {
		SimpleAnt testant = new SimpleAnt(1,2,2,null);
		testant.hungrier();
		
		testant.eatFood();
		
		assertEquals(1,testant.getHungerValue());
	}
	
	@Test
	void testEatFood_reducesNutritionToZero_foodShouldBeDropped() {
		FakeFood testfood = new FakeFood();
		SimpleAnt testant = new SimpleAnt(1,2,2,testfood);
		testant.eatFood();
		assertNull(testant.getFood());
	}
	
	@Test
	void testPickUpFood_ifAntHasFood_OldFoodShouldBeDropped() {
		FakeFood testfood = new FakeFood();
		FakeFood testfood2 = new FakeFood();
		
		SimpleAnt testant = new SimpleAnt(1,2,2,testfood);
		
		testant.pickupFood(testfood2);
		
		assertTrue(testfood.setPointInput!=null);
	}
	
	@Test
	void testPickUpFood_ifAntHasFood_NewFoodShouldBeHeld() {
		FakeFood oldFood = new FakeFood();
		FakeFood newFood = new FakeFood();
		SimpleAnt testant = new SimpleAnt(1,2,2,oldFood);
		
		testant.pickupFood(newFood);
		
		assertTrue(testant.getFood() == newFood);
	}
}