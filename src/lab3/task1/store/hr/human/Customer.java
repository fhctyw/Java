package lab3.task1.store.hr.human;

import lab3.task1.store.storage.Good;

import java.util.Objects;

public class Customer implements Buyer {
    private String name;
    private int money;

    public Customer(final String name, final int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(final int money) {
        this.money = money;
    }

    @Override
    public void buy(final Good good) {
        if (money < good.getPrice()) {
            throw new NotEnoughMoney();
        }
        money -= good.getPrice();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Customer customer = (Customer) o;
        return money == customer.money && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name='" + name + "', money='" + money + "'}";
    }
}
