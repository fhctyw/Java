package lab3.task1.store.storage;

import java.util.UUID;

public class GoodService {
    public static Good makeGood(final UUID uuid, final String name, final double price) {
        final Good good = new Good();
        good.setUuid(uuid);
        good.setName(name);
        good.setPrice(price);
        return good;
    }
}
