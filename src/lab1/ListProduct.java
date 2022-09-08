package lab1;

import java.util.List;

public class ListProduct {

    private List<PairProduct> listPairProduct;

    public ListProduct(final List<PairProduct> listPairProduct) {
        this.listPairProduct = listPairProduct;
    }

    public List<PairProduct> getListPairProduct() {
        return listPairProduct;
    }

    public void setListPairProduct(final List<PairProduct> listPairProduct) {
        this.listPairProduct = listPairProduct;
    }

    public double calcPrice() {
        double sum = 0.0;
        for (final PairProduct pairProduct : listPairProduct) {

            final double discount = 1 - pairProduct.getProduct().getDiscount();
            sum += pairProduct.getCount() * pairProduct.getProduct().getPrice() * discount;
        }
        return sum;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (final PairProduct pairProduct : listPairProduct) {
            builder.append(pairProduct.toString()).append('\n');
        }
        return builder.toString();
    }
}
