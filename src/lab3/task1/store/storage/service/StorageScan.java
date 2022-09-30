package lab3.task1.store.storage.service;

import lab3.task1.store.storage.Good;
import lab3.task1.store.storage.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;

public class StorageScan extends StorageService {
    public StorageScan(final Storage storage) {
        super(storage);
    }

    public List<Good> getByCondition(final Predicate<? super Map.Entry<UUID, Good>> predicate) {
        final List<Good> goodList = new ArrayList<>();
        storage.getGoods()
                .entrySet()
                .stream()
                .filter(predicate)
                .forEach(e -> goodList.add(e.getValue()));
        return goodList;
    }

    public UUID scanByName(final String nameGood) {
        final Good good = getByCondition(e -> e.getValue().getName().equals(nameGood)).stream().findFirst().orElse(null);
        if (good == null) {
            throw new GoodNotExist();
        }
        return good.getUuid();
    }
}
