package lab3.task1.store.storage.service;

import lab3.task1.store.storage.Good;
import lab3.task1.store.storage.Storage;

import java.util.UUID;

public class StorageSeller extends StorageService {
    public StorageSeller(final Storage storage) {
        super(storage);
    }
    public void sellGood(final UUID uuid) {
        storage.getGoods().remove(uuid);
    }
}
