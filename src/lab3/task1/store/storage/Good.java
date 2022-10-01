package lab3.task1.store.storage;

import java.util.Objects;
import java.util.UUID;

public class Good {
    private UUID uuid = UUID.randomUUID();
    private String name;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public UUID getUuid() {
        return uuid;
    }

    protected void setUuid(final UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Good() {

    }

    public Good(final String name, final double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Good good = (Good) o;
        return Double.compare(good.price, price) == 0 && Objects.equals(uuid, good.uuid) && Objects.equals(name, good.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, price);
    }

    @Override
    public String toString() {
        return "{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
