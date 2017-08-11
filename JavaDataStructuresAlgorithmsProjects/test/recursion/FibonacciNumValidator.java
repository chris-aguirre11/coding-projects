package recursion;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciNumValidator {

	@Test
	public void testGenerateFibNum() {
		int fibonacciIndexToFind = 21;
		Assert.assertTrue("Fibonacci # generated for Fibonacci Index: " + fibonacciIndexToFind + 
				" is incorrect", FibonacciNumGenerator.generateFibNum(21) == 10946);
	}
}
