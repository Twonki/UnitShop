package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import org.junit.jupiter.api.Test;

import Code.Food;

public class FoodTest {
	
	@Test
	void testConstructor_allValuesAreOk_shouldBeBuildWithSetValues() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	@Test
	void testConstructor_nameIsNull_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> new Food(null,1,1,100));
	}
	
}
