package lab3.task1.store.storage.service;

import lab3.task1.store.report.Report;
import lab3.task1.store.storage.Good;
import lab3.task1.store.storage.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StorageService {
    protected Storage storage;

    public StorageService(final Storage storage) {
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(final Storage storage) {
        this.storage = storage;
    }

    public boolean exist() {
        return storage != null;
    }

    public int count() {
        return storage.getGoods().size();
    }

    public Report putGood(final Good good) {
        if (storage.getGoods().containsKey(good.getUuid())) {
            System.out.println("Good already exists. Skipping...");
            return null;
        }
        storage.getGoods().put(good.getUuid(), good);
        return new Report(Stream.of(good).collect(Collectors.toList()));
    }

    public Report putGood(final List<Good> goods) {
        goods.forEach(this::putGood);
        return new Report(new ArrayList<Good>(goods));
    }

    public void putNoReport(final Good good) {
        if (storage.getGoods().containsKey(good.getUuid())) {
            System.out.println("Good already exists. Skipping...");
            return;
        }
        storage.getGoods().put(good.getUuid(), good);
    }

    public void putNoReport(final List<Good> goods) {
        goods.forEach(this::putNoReport);
    }

    public Good getGood(final UUID uuid) {
        if (!storage.getGoods().containsKey(uuid)) {
            throw new GoodNotExist();
        }
        return storage.getGoods().get(uuid);
    }

    public List<Good> getGood(final List<UUID> uuids) {
        final List<Good> goods = new ArrayList<Good>();
        uuids.forEach(e -> goods.add(getGood(e)));
        return goods;
    }

    public List<Good> getAllGoods() {
        return new ArrayList<Good>(storage.getGoods().values());
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

    public void sellGood(final UUID uuid) {
        storage.getGoods().remove(uuid);
    }
}
