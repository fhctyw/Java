package lab3.task1.store.hr;

import java.io.Serializable;
import java.util.List;

public class PurchaseHistory implements Serializable {
    private List<Purchase> purchases;

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(final List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public PurchaseHistory(final List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        purchases.forEach(e -> stringBuilder.append(e).append('\n'));
        return stringBuilder.toString();
    }

    //    public boolean add(final Purchase purchase, final Employee employee) {
//        purchases.add(purchase);
//        return true;
//    }

//    public PurchaseHistory getBuyerHistory(final Buyer buyer) {
//        return new PurchaseHistory(purchases.stream().filter(e -> e.getBuyer().equals(buyer)).collect(Collectors.toList()));
//    }
}
