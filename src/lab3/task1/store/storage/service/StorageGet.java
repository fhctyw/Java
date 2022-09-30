package lab3.task1.store.storage.service;

import lab3.task1.store.storage.Good;
import lab3.task1.store.storage.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StorageGet extends StorageService {
    public StorageGet(final Storage storage) {
        super(storage);
    }

    public Good get(final UUID uuid) {
        if (!storage.getGoods().containsKey(uuid)) {
            throw new GoodNotExist();
        }
        return storage.getGoods().get(uuid);
    }

    public List<Good> get(final List<UUID> uuids) {
        final List<Good> goods = new ArrayList<Good>();
        uuids.forEach(e -> goods.add(get(e)));
        return goods;
    }

    public List<Good> getAllGoods() {
        return new ArrayList<Good>(storage.getGoods().values());
    }
}
