package lab1;

import java.util.List;

public class Task7 {

	public static void DisplayListProduct(final ListProduct listProduct) {
		System.out.println(listProduct);
		System.out.println("Total price = " + listProduct.calcPrice() + "$");
	}
	
	public static void main(final String[] args) {

		final ListProduct listProduct = new ListProduct(List.of(
			new PairProduct(new Product("pen", 2.4, 0.0), 3),
			new PairProduct(new Product("book", 0.5, 0.03), 14),
			new PairProduct(new Product("apple", 1.2, 0.11), 52)
		));
		DisplayListProduct(listProduct);
	}
}
