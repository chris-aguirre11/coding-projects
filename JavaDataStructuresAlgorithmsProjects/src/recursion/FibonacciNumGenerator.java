package recursion;

public final class FibonacciNumGenerator {
	/**
     * Don't let anyone instantiate this class.
     */
    private FibonacciNumGenerator() {}
	
	public static int generateFibNum(int n) {
		if(n <= 0) return 0;
		else if(n == 1) return 1;
		else if(n == 2) return 1;
		else return generateFibNum(n-2) + generateFibNum(n-1);
	}
}
