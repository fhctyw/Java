package lab3.task1.store.database;

public interface StoreIO {
    boolean save(final Object serializableObject);
    Object load();
}

