package lab3.task1.store.storage.service;

import lab3.task1.store.database.FileTextService;
import lab3.task1.store.storage.Good;
import lab3.task1.store.storage.GoodService;
import lab3.task1.store.storage.Storage;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class StorageFileText extends FileTextService {
    public StorageFileText(final Object object, final String name) {
        super(object, name);
    }

    public StorageFileText(final Object object) {
        super(object);
    }

    @Override
    public void save() throws IOException {
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(name));

        final Storage storage = (Storage) object;
        for (final Map.Entry<UUID, Good> uuidGoodEntry : storage.getGoods().entrySet()) {
            final UUID key = uuidGoodEntry.getKey();
            final Good value = uuidGoodEntry.getValue();
            final String line = key.toString() +
                    ',' + value.getName() +
                    ',' + String.valueOf(value.getPrice())
                    + System.lineSeparator();
            bufferedWriter.write(line);
        }

        bufferedWriter.close();
    }

    private Good parseGood(final String goodString) {
        final String[] stringsGood = goodString.split(",");
        final UUID uuid = UUID.fromString(stringsGood[0]);
        final String name = stringsGood[1];
        final double price = Double.parseDouble(stringsGood[2]);
        return GoodService.makeGood(uuid, name, price);
    }

    @Override
    public void load() throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(name));
        final Storage storage = (Storage) object;

        final TreeMap<UUID, Good> treeMap = new TreeMap<UUID, Good>();
        bufferedReader.lines().forEach(
                line -> {
                    final Good good = parseGood(line);
                    treeMap.put(good.getUuid(), good);
                });
        storage.setGoods(treeMap);

        bufferedReader.close();
    }
}
