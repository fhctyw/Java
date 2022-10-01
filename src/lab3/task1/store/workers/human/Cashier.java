package lab3.task1.store.workers.human;

import lab3.task1.store.hr.PurchaseHistory;
import lab3.task1.store.hr.human.Buyer;
import lab3.task1.store.storage.Good;

public class Cashier implements Seller {
    private String name;
    private int salary;


    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(final int salary) {
        this.salary = salary;
    }

    public Cashier(final String name, final int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void sell(final Buyer buyer, final Good good) {

    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

}
