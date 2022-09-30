package lab3.task1.store.hr.service;

import lab3.task1.store.hr.Purchase;
import lab3.task1.store.hr.PurchaseHistory;
import lab3.task1.store.hr.human.Buyer;
import lab3.task1.store.storage.Good;
import lab3.task1.store.workers.human.Seller;

import java.time.LocalDateTime;

public class PurchaseHistoryAdd extends PurchaseHistoryService {
    public PurchaseHistoryAdd(final PurchaseHistory purchaseHistory) {
        super(purchaseHistory);
    }

    public void addPurchase(final LocalDateTime localDateTime, final Good good, final Buyer buyer, final Seller seller) {
        purchaseHistory.getPurchases().add(new Purchase(localDateTime, good, buyer, seller));
    }
}
