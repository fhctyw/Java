package lab3.task1.store.hr.human;

import lab3.task1.store.storage.Good;

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
    public String toString() {
        return getClass().getSimpleName() + "{name='" + name + "', money='" + money + "'}";
    }
}
