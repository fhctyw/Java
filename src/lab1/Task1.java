package lab1;

import java.util.Arrays;
import  java.lang.String;

public class Task1 {

	private static void displayArrayString(final String[] array, final char symbol) {
		for (final String str : array) {
			System.out.println("[" + str.chars().filter(ch -> ch == symbol).count() + "] " + str); 
		}
		System.out.println();
	}

	private static void sort(final String[] arrayString, final char symbol) {
		Arrays.sort(arrayString, new StringComparator(symbol));
	}
	
	public static void main(final String[] args) {
		final String[] arrayString = {"test", "tattoo", "potato", "task", "fruit", "apple"};
		final char symbol1 = 't';
		final char symbol2 = 'o';
		displayArrayString(arrayString, symbol1);
		sort(arrayString, symbol1);
		System.out.println("Sorting ArrayString per '" + symbol1 + "'");
		displayArrayString(arrayString, symbol1);
		sort(arrayString, symbol2);
		System.out.println("Sorting ArrayString per '" + symbol2 + "'");
		displayArrayString(arrayString, symbol2);
	}
}
