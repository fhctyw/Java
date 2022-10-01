package lab3.task1.store.service;

import lab3.task1.store.Store;
import lab3.task1.store.hr.human.Buyer;
import lab3.task1.store.hr.service.PurchaseHistoryAdd;
import lab3.task1.store.storage.Good;
import lab3.task1.store.storage.service.StorageSeller;
import lab3.task1.store.workers.human.Seller;

import java.time.LocalDateTime;
import java.util.UUID;

public class StoreSeller extends StoreService {
    public StoreSeller(final Store store) {
        super(store);
    }

    public void sellGood(final Seller seller, final Buyer buyer, final UUID uuidGood) {
        final PurchaseHistoryAdd purchaseHistoryAdd = new PurchaseHistoryAdd(store.getPurchaseHistory());
        purchaseHistoryAdd.addPurchase(LocalDateTime.now(), store.getStorage().getGoods().get(uuidGood), buyer, seller);

        seller.sell(buyer, store.getStorage().getGoods().get(uuidGood));
        buyer.buy(store.getStorage().getGoods().get(uuidGood));

        final StorageSeller storageSeller = new StorageSeller(store.getStorage());
        storageSeller.sellGood(uuidGood);
    }
}
