package lab1;

import java.lang.reflect.Method;


public class Task9 {
	public static void DisplayOperationLong(final long long1, final long long2){
		System.out.println(long1 + " * " + long2 + " = " + Calculator.mult(long1, long2));
		System.out.println(long1 + " / " + long2 + " = " + Calculator.div(long1, long2));
	}

	public static void DisplayOperationDouble(final CustomDouble double1, final CustomDouble double2){
		System.out.println(double1 + " * " + double2 + " = " + Calculator.mult(double1, double2) + " real type = " + Calculator.mult(double1, double2).getClass().getSimpleName());
		System.out.println(double1 + " / " + double2 + " = " + Calculator.div(double1, double2) + " real type = " + Calculator.div(double1, double2).getClass().getSimpleName());
	}

	public static void main(final String[] args) {

		final long long1 = 14000040L;
		final long long2 = 14144L;
		final CustomDouble double1 = new CustomDouble(4.51);
		final CustomDouble double2 = new CustomDouble(5.49);


		DisplayOperationLong(long1, long2);
		DisplayOperationDouble(double1, double2);
	}

}
