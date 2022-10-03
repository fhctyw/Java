package lab3.task1.store.hr.service;

import lab3.task1.store.hr.Purchase;
import lab3.task1.store.hr.PurchaseHistory;
import lab3.task1.store.hr.human.Buyer;
import lab3.task1.store.storage.Good;
import lab3.task1.store.workers.human.Seller;

import java.time.LocalDateTime;

public class PurchaseHistoryService {
    protected PurchaseHistory purchaseHistory;

    public PurchaseHistory getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(final PurchaseHistory purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public PurchaseHistoryService(final PurchaseHistory purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public boolean exist() {
        return purchaseHistory != null;
    }

    public int count() {
        return purchaseHistory.getPurchases().size();
    }

    public void addPurchase(final LocalDateTime localDateTime, final Good good, final Buyer buyer, final Seller seller) {
        purchaseHistory.getPurchases().add(new Purchase(localDateTime, good, buyer, seller));
    }
}
