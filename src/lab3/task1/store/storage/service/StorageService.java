package lab3.task1.store.storage.service;

import lab3.task1.store.storage.Storage;

public abstract class StorageService {
    protected Storage storage;

    public StorageService(final Storage storage) {
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(final Storage storage) {
        this.storage = storage;
    }
}
