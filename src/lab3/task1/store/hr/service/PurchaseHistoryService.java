package lab3.task1.store.hr.service;

import lab3.task1.store.hr.PurchaseHistory;

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
}
