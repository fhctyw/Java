package lab1;

public class Task3 {
	
	private static long loopFactorial(final int x) {
		long num = 1;
		for(long i = 1; i <= x; i++) {
			num *= i;
		}
		return num;
	}
	
	private static long RecursionFactorial(final int x) {
		if (x < 1) {
			return 1;
		}
		return x * RecursionFactorial(x-1);
	}
	
	public static void main(final String[] args) {
		for (int x = 0; x < 16; x++) {
			System.out.println(x + "! = " + loopFactorial(x) + " == " + RecursionFactorial(x));
		}
	}
}
