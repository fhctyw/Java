package lab1;

public class Task8 {

	public static void DisplayOperators(final CustomDouble cd1, final CustomDouble cd2) {
		System.out.println("First number = " + cd1);
		System.out.println("Second number = " + cd2);
		System.out.print(cd1 + " + " + cd2 + " = ");
		cd1.add(cd2);
		System.out.println(cd1);
		System.out.println("First number = " + cd1);
		System.out.print(cd1 + " - " + cd2 + " = ");
		cd1.minus(cd2);
		System.out.println(cd1);
		System.out.println("First number = " + cd1);
		System.out.println(cd1 + " == " + cd2 + " = " + cd1.equals(cd2));
		System.out.println(cd1 + " == " + cd1 + " = " + cd1.equals(cd1));
	}
	
	public static void main(final String[] args) {
		final CustomDouble cd1 = new CustomDouble(2.5);
		final CustomDouble cd2 = new CustomDouble(-4.0);
		DisplayOperators(cd1, cd2);
	}
}
