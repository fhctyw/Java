package lab1;

public class Product {
	private String name;
	private double price;
	private double discount;

	public Product(final String name, final double price, final double discount) {
		this.name = name;
		this.price = price;
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(final double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(final double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return name + " " + price + "$ " + (int)(discount*100) + "%";
	}
}
