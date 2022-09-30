package lab3.task1.store.storage.service;

import lab3.task1.store.report.Report;
import lab3.task1.store.storage.Good;
import lab3.task1.store.storage.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StoragePut extends StorageService {
    public StoragePut(final Storage storage) {
        super(storage);

    }
    private void validateUuid(final Good good) {
        if (storage.getGoods().containsKey(good.getUuid())) {
            throw new GoodAlreadyExist();
        }
    }
    public Report put(final Good good) {
        validateUuid(good);
        storage.getGoods().put(good.getUuid(), good);
        return new Report(Stream.of(good).collect(Collectors.toList()));
    }

    public Report put(final List<Good> goods) {
        goods.forEach(this::validateUuid);
        goods.forEach(e -> storage.getGoods().put(e.getUuid(), e));
        return new Report(new ArrayList<Good>(goods));
    }

    public void putNoReport(final Good good) {
        validateUuid(good);
        storage.getGoods().put(good.getUuid(), good);
    }

    public void putNoReport(final List<Good> goods) {
        goods.forEach(this::validateUuid);
        goods.forEach(this::putNoReport);
    }
}
