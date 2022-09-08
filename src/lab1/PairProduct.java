package lab1;

public class PairProduct {
	private Product product;
	private int count;

	public PairProduct(final Product product, final int count) {
		this.product = product;
		this.count = count;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(final Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(final int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		
		return 
				"[" + product.toString() + "]" + 
				"[count = " + count + "]" + 
				String.format("[without discount = %.2f$]", count*product.getPrice()) +
				String.format("[total price = %.2f$]", count*product.getPrice()*(1-product.getDiscount()));
	}
}
