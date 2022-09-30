package lab3.task1.store.service;

import lab3.task1.store.Store;

public class CheckStore extends StoreService {
    public CheckStore(final Store store) {
        super(store);
    }

    public boolean checkStorage() {
        return store.getStorage() != null;
    }

    public boolean checkWorkers() {
        return store.getWorkers() != null;
    }

    public boolean checkPurchaseHistory() {
        return store.getPurchaseHistory() != null;
    }

    public int getGoodCount() {
        return store.getStorage().getGoods().size();
    }
}
