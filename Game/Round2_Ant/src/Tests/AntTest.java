package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import Code.Ant;
import Code.SimpleFood;

public class AntTest {

	@Test
	void testConstructor_allValuesAreOK_shouldBeBuildwithSetValues() {
		SimpleFood testfood = new SimpleFood("Birne",1,1,10);
		Ant testant = new Ant(1,2,2,10,testfood);
		assertTrue(testant.id == 1);
		assertTrue(testant.point.x == 2);
		assertTrue(testant.point.y == 2);
		assertTrue(testant.hungerValue == 10);
		assertTrue(testant.food.equals(testfood));
	}
	
	@Test
	void testConstructor_IdIsNegative_shouldThrowException() {
		SimpleFood testfood = new SimpleFood("Birne",1,1,10);
		assertThrows(IllegalArgumentException.class, () -> new Ant(-1,1,1,10,testfood));
	}

	@Test
	void testConstructor_xPointIsNegative_shouldThrowException() {
		SimpleFood testfood = new SimpleFood("Birne",1,1,10);
		assertThrows(IllegalArgumentException.class, () -> new Ant(1,-1,1,10,testfood));
	}
	
	@Test
	void testConstructor_yPointIsNegative_shouldThrowException() {
		SimpleFood testfood = new SimpleFood("Birne",1,1,10);
		assertThrows(IllegalArgumentException.class, () -> new Ant(1,1,-1,10,testfood));
	}
	
	@Test
	void testConstructor_hungerValueIsNegative_shouldThrowException() {
		SimpleFood testfood = new SimpleFood("Birne",1,1,10);
		assertThrows(IllegalArgumentException.class, () -> new Ant(1,1,1,-10,testfood));
	}
	
	@Test
	void testPickUpFood_FoodValueIsOk_shouldBeBuildWithSetValues() {
		SimpleFood testfood = new SimpleFood("Birne",1,1,10);
		Ant testant = new Ant(1,2,2,10,testfood);
		testant.pickupFood(testfood);
		assertTrue(testant.food.equals(testfood));
	}
	
	@Test
	void testDropFood_DropFood_shouldBeDroppedAndSetToNull() {
		SimpleFood testfood = new SimpleFood("Birne",1,1,10);
		Ant testant = new Ant(1,2,2,10,testfood);
		testant.pickupFood(testfood);
		testant.dropFood();
		assertTrue(testant.food == null);
	}
	
	@Test
	void testDropFood_DropFood_FoodPositionShouldBeSetToAntPosition() {
		SimpleFood testfood = new SimpleFood("Birne",1,1,10);
		Ant testant = new Ant(1,2,2,10,testfood);
		testant.pickupFood(testfood);
		testant.dropFood();
		assertTrue(testfood.getPoint().x == 2 && testfood.getPoint().y == 2);
	}
	
	@Test
	void testEatFood_NibbleOnFood_hungerValueReducedByAmount() {
		SimpleFood testfood = new SimpleFood("Birne",1,1,5);
		Ant testant = new Ant(1,2,2,10,testfood);
		testant.pickupFood(testfood);
		testant.eatFood(5);
		assertEquals(5,testant.hungerValue);
	}
	
	
	@Test
	void testMove_MoveFood_FoodShouldBeMovedToNewPoint() {
		Point testpoint = new Point(3,3);
		SimpleFood testfood = new SimpleFood("Birne",1,1,5);
		Ant testant = new Ant(1,2,2,10,testfood);
		testant.move(testpoint);
		assertEquals(testant.point,testpoint);
	}
	
	@Test
	void testHungrier_callMethod_HungerValueShouldBeIncreased() {
		SimpleFood testfood = new SimpleFood("Birne",1,1,5);
		Ant testant = new Ant(1,2,2,10,testfood);
		testant.hungrier();
		assertEquals(11,testant.hungerValue);
	}
	//ok to use other functions which are already tested like drop food in here?
	@Test
	void testDropFood_ifAntHasNoFoodToDrop_NothingShouldHappen() {
		SimpleFood testfood = new SimpleFood("Birne",1,1,5);
		Ant testant = new Ant(1,2,2,10,testfood);
		Point testpoint = new Point(3,3);
		testant.dropFood();	
		testant.move(testpoint);
		testant.dropFood();
		assertEquals(2,testfood.getPoint().x);
		assertEquals(2,testfood.getPoint().y);
	}
	
	@Test
	void testEatFood_ifAntHasNoFoodToEat_NothingShouldHappen() {
		SimpleFood testfood = new SimpleFood("Birne",1,1,5);
		Ant testant = new Ant(1,2,2,10,testfood);
		testant.dropFood();
		testant.eatFood(5);
		assertEquals(10,testant.hungerValue);
	}
	
	@Test
	void testEatFood_reducesNutritionToZero_foodShouldBeDropped() {
		SimpleFood testfood = new SimpleFood("Birne",1,1,5);
		Ant testant = new Ant(1,2,2,10,testfood);
		testant.eatFood(5);
		assertEquals(null,testant.food);
	}
	
	//Bereits in Food_test abgedeckt?? trzdm nötig?
	@Test
	void testEatFood_reducesNutrition_ShouldBeReducedByNibbledAmount() {
		SimpleFood testfood = new SimpleFood("Birne",1,1,5);
		Ant testant = new Ant(1,2,2,10,testfood);
		testant.eatFood(2);
		assertEquals(3,testant.food.nutritionValue);
	}
	
	@Test
	void testPickUpFood_ifAntHasFood_OldFoodShouldBeDropped() {
		SimpleFood testfood = new SimpleFood("Birne",1,1,5);
		SimpleFood testfood2 = new SimpleFood("Apfel",1,1,10);
		Ant testant = new Ant(1,2,2,10,testfood);
		testant.pickupFood(testfood2);
		assertEquals(2,testfood.getPoint().x);
		assertEquals(2,testfood.getPoint().y);
	}
	
	@Test
	void testPickUpFood_ifAntHasFood_NewFoodShouldBeHeld() {
		SimpleFood testfood = new SimpleFood("Birne",1,1,5);
		SimpleFood testfood2 = new SimpleFood("Apfel",1,1,10);
		Ant testant = new Ant(1,2,2,10,testfood);
		testant.pickupFood(testfood2);
		assertTrue(testant.food == testfood2);
	}
}


/*
void testConstructor_nameIsNull_shouldThrowException() {
	assertThrows(IllegalArgumentException.class, () -> new Food(null,1,1,100));
}
*/