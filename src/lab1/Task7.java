package lab1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task7 {

	public static void DisplayListProduct(final ListProduct listProduct) {
		System.out.println(listProduct);
		System.out.println("Total price = " + listProduct.calcPrice() + "$");
	}
	
	public static void main(final String[] args) {

		final ListProduct listProduct = new ListProduct(Stream.of(
			new PairProduct(new Product("pen", 2.4, 0.0), 3),
			new PairProduct(new Product("book", 0.5, 0.03), 14),
			new PairProduct(new Product("apple", 1.2, 0.11), 52)
		).collect(Collectors.toList()));
		DisplayListProduct(listProduct);
	}
}
