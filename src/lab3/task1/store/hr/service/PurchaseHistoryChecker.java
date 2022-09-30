package lab3.task1.store.hr.service;

import lab3.task1.store.hr.PurchaseHistory;

public class PurchaseHistoryChecker extends PurchaseHistoryService {
    public PurchaseHistoryChecker(final PurchaseHistory purchaseHistory) {
        super(purchaseHistory);
    }

    public boolean exist() {
        return purchaseHistory != null;
    }

    public int count() {
        return purchaseHistory.getPurchases().size();
    }
}
