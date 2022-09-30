package lab3.task1.store.workers.service;

import lab3.task1.store.hr.PurchaseHistory;
import lab3.task1.store.hr.human.Buyer;
import lab3.task1.store.hr.service.PurchaseHistoryAdd;
import lab3.task1.store.storage.Good;
import lab3.task1.store.workers.human.Seller;

import java.time.LocalDateTime;

public class SellerService {
    protected PurchaseHistory purchaseHistory;

    public PurchaseHistory getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(final PurchaseHistory purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public SellerService(final PurchaseHistory purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public void sell(final Seller seller, final Buyer buyer, final Good good) {
        final PurchaseHistoryAdd purchaseHistoryAdd = new PurchaseHistoryAdd(purchaseHistory);
        purchaseHistoryAdd.addPurchase(LocalDateTime.now(), good, buyer, seller);
        seller.sell(buyer, good);
        buyer.buy(good);
    }
}
