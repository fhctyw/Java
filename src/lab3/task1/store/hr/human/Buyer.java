package lab3.task1.store.hr.human;

import lab3.task1.store.database.DatabaseSerialization;
import lab3.task1.store.storage.Good;

public interface Buyer extends DatabaseSerialization {
    void buy(final Good good);
}
