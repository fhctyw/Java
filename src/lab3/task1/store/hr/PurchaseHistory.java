package lab3.task1.store.hr;

import java.util.List;

public class PurchaseHistory {
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
}
