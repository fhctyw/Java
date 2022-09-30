package lab3.task1.store;

import lab3.task1.store.hr.PurchaseHistory;
import lab3.task1.store.storage.Storage;
import lab3.task1.store.workers.Workers;

public class Store {
    private Storage storage;
    private Workers workers;
    private PurchaseHistory purchaseHistory;

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(final Storage storage) {
        this.storage = storage;
    }

    public Workers getWorkers() {
        return workers;
    }

    public void setWorkers(final Workers workers) {
        this.workers = workers;
    }

    public PurchaseHistory getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(final PurchaseHistory purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public Store(final Storage storage, final Workers workers, final PurchaseHistory purchaseHistory) {
        this.storage = storage;
        this.workers = workers;
        this.purchaseHistory = purchaseHistory;
    }
}
