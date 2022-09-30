package lab3.task1.store.storage.service;

import lab3.task1.store.database.FileTextService;
import lab3.task1.store.storage.Good;
import lab3.task1.store.storage.Storage;

import java.io.IOException;
import java.util.TreeMap;
import java.util.UUID;

public class StorageFileText extends FileTextService {
    public StorageFileText(final Object object, final String name) {
        super(object, name);
    }

    public StorageFileText(final Object object) {
        super(object);
    }

    @Override
    public void save() throws IOException {

        final Storage storage = (Storage) object;
        storage.getGoods()
                .forEach((key, value) -> {
                    final String stringBuilder = key.toString() +
                            ',' + value.getName() +
                            ',' + String.valueOf(value.getPrice()) +
                            System.lineSeparator();
                    bufferedWriter.write(stringBuilder);
                });
    }

    private Good parseGood(final String goodString) {
        final String stringUuid = goodString.substring(0, 36);
        //String res = goodString.substring(36);
        final int indexOfStartGoodName = 36;
        final int indexOfEndGoodName;
    }

    @Override
    public void load() throws IOException {
        final Storage storage = new Storage(new TreeMap<UUID, Good>());

        String line;
        while ((line = bufferedReader.readLine()) != null) {

        }
    }
}
