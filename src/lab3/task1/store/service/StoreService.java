package lab3.task1.store.service;

import lab3.task1.store.Store;
import lab3.task1.store.hr.Purchase;
import lab3.task1.store.hr.PurchaseHistory;
import lab3.task1.store.storage.Good;
import lab3.task1.store.storage.Storage;
import lab3.task1.store.workers.Workers;
import lab3.task1.store.workers.human.Employee;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.UUID;

public class StoreService {
    protected Store store;

    public Store getStore() {
        return store;
    }

    public void setStore(final Store store) {
        this.store = store;
    }

    public StoreService(final Store store) {
        this.store = store;
    }

    public static Store nullStore() {
        return new Store(null, null, null);
    }
    public static Store emptyStore() {
        return new Store(new Storage(new TreeMap<UUID, Good>()), new Workers(new ArrayList<Employee>()), new PurchaseHistory(new ArrayList<Purchase>()));
    }
}
