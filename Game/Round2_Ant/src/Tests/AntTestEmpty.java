package Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import Code.Ant;
import Code.FakeFood;

public class AntTest {

	@Test
	void testSomething_allValuesAreOK_shouldNotThrowException() {
		FakeFood testfood = new FakeFood();
		
		Ant testant = new Ant(1,2,2,testfood);
	
		assertTrue(testant.id == 1);
	}
}