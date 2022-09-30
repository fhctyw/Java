package lab3.task1.store.workers.human;

import lab3.task1.store.hr.human.Buyer;
import lab3.task1.store.storage.Good;

public interface Seller extends Employee {
    void sell(Buyer customer, final Good good);
}
