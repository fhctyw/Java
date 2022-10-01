package lab3.task1.store.database;

public interface DatabaseSerialization {
    String serializationForDatabase();
    void deserializationFromDatabase(String text);
}
