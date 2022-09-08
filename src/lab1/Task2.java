package lab1;

public class Task2 { 

	private static String removeSymbol(final String string, final char symbol) {
		return string.replace(Character.toString(symbol), "");
	}
	
	public static void main(final String[] args) {
		final String String = "Hello world";
		final char Symbol = 'o';
		System.out.println("Standard string = \"" + String + '\"');
		System.out.println("String after remove '" + Symbol + "' symbol = \"" + removeSymbol(String, Symbol) + '\"');
	}
}
