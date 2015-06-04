package stack;

import java.util.EmptyStackException;
import java.util.concurrent.BrokenBarrierException;

import org.junit.Assert;
import org.junit.Test;

public class StackTester {

	@Test
	public void basicStackUsingLLTest() {
		StackUsingLL stack = new StackUsingLL();
		
		// amoreroma (a palindrome)
		stack.push('a');
		stack.push('m');
		stack.push('o');
		stack.push('r');
		stack.push('e');
		
		char currentTopValue = (char) stack.peek();
		Assert.assertTrue("Unexpected top value. Expected 'e' but was " + currentTopValue, 'e' == currentTopValue);
		
		stack.push('r');
		stack.push('o');
		stack.push('m');
		stack.push('a');
		
		Assert.assertTrue("Expected isEmpty() to return false", !stack.isEmpty());
		
		currentTopValue = (char) stack.peek();
		Assert.assertTrue("Unexpected top value. Expected 'a' but was " + currentTopValue, 'a' == currentTopValue);
		
		Assert.assertTrue("Unexpected popped value. Expected 'a' but was " + currentTopValue, 'a' == (char)stack.pop());
		
		currentTopValue = (char) stack.peek();
		Assert.assertTrue("Unexpected top value. Expected 'm' but was " + currentTopValue, 'm' == currentTopValue);
		
		Assert.assertTrue("Unexpected popped value. Expected 'm' but was " + currentTopValue, 'm' == (char)stack.pop());
		Assert.assertTrue("Unexpected popped value. Expected 'o' but was " + currentTopValue, 'o' == (char)stack.pop());
		Assert.assertTrue("Unexpected popped value. Expected 'r' but was " + currentTopValue, 'r' == (char)stack.pop());
		
		Assert.assertTrue("Expected isEmpty() to return false", !stack.isEmpty());
		
		Assert.assertTrue("Expected currentSize to be 5 but was " + stack.getCurrentSize(), 5 == stack.getCurrentSize());
		
		Assert.assertTrue("Unexpected popped value. Expected 'e' but was " + currentTopValue, 'e' == (char)stack.pop());
		Assert.assertTrue("Unexpected popped value. Expected 'r' but was " + currentTopValue, 'r' == (char)stack.pop());
		Assert.assertTrue("Unexpected popped value. Expected 'o' but was " + currentTopValue, 'o' == (char)stack.pop());
		
		Assert.assertTrue("Expected currentSize to be 2 but was " + stack.getCurrentSize(), 2 == stack.getCurrentSize());
		
		Assert.assertTrue("Unexpected popped value. Expected 'm' but was " + currentTopValue, 'm' == (char)stack.pop());
		Assert.assertTrue("Unexpected popped value. Expected 'a' but was " + currentTopValue, 'a' == (char)stack.pop());
		
		Assert.assertTrue("Expected currentSize to be 0 but was " + stack.getCurrentSize(), 0 == stack.getCurrentSize());
		
		Assert.assertTrue("Expected isEmpty() to return true", stack.isEmpty());
	}
	
	@Test(expected = EmptyStackException.class)
	public void ensureEmptyStackExceptionIsThrown1() {
		StackUsingLL stack = new StackUsingLL();
		stack.pop();
	}
	
	@Test(expected = EmptyStackException.class)
	public void ensureEmptyStackExceptionIsThrown2() {
		StackUsingLL stack = new StackUsingLL();
		
		stack.push(5);
		stack.push(6);
		
		stack.pop();
		stack.pop();
		stack.pop();
	}
}
