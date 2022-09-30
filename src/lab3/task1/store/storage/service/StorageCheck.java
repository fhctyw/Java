package lab3.task1.store.storage.service;

import lab3.task1.store.storage.Storage;

public class StorageCheck extends StorageService {
    public StorageCheck(final Storage storage) {
        super(storage);
    }

    public boolean exist() {
        return storage != null;
    }

    public int count() {
        return storage.getGoods().size();
    }
}
