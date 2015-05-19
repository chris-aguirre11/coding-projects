package recursion;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciNumValidator {

	@Test
	public void testGenerateFibNum() {
		int fibonacciIndexToFind = 36;
		Assert.assertTrue("Fibonacci # generated for Fibonacci Index: " + fibonacciIndexToFind + 
				" is incorrect", FibonacciNumGenerator.generateFibNum(36) == 14930352);
	}
}
