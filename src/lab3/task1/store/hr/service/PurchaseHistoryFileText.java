package lab3.task1.store.hr.service;

import lab3.task1.store.database.FileTextService;
import lab3.task1.store.hr.Purchase;
import lab3.task1.store.hr.PurchaseHistory;
import lab3.task1.store.hr.human.Buyer;
import lab3.task1.store.storage.Good;
import lab3.task1.store.storage.GoodService;
import lab3.task1.store.storage.Storage;
import lab3.task1.store.workers.human.Seller;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PurchaseHistoryFileText extends FileTextService {
    public PurchaseHistoryFileText(final Object object, final String name) {
        super(object, name);
    }

    public PurchaseHistoryFileText(final Object object) {
        super(object);
    }

    @Override
    public void save() throws IOException {
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(name));

        final PurchaseHistory purchaseHistory = (PurchaseHistory) object;
        for (final Purchase purchase : purchaseHistory.getPurchases()) {
            final String line = purchase.getDateTime().toString()
                    + ',' + purchase.getGood().getUuid()
                    + ',' + purchase.getGood().getName()
                    + ',' + purchase.getGood().getPrice()
                    + ',' + purchase.getBuyer().serializationForDatabase()
                    + ',' + purchase.getSeller().serializationForDatabase()
                    + System.lineSeparator();
            bufferedWriter.write(line);
        }

        bufferedWriter.close();
    }

    private Purchase parsePurchase(final String line) {
        final String[] stringsPurchase = line.split(",");

        final LocalDateTime localDateTime = LocalDateTime.parse(stringsPurchase[0]);
        final Good good = GoodService.makeGood(UUID.fromString(stringsPurchase[1]), stringsPurchase[2], Double.parseDouble(stringsPurchase[3]));
        final Buyer buyer = null;
        buyer.deserializationFromDatabase(stringsPurchase[4]);
        final Seller seller = null;
        seller.deserializationFromDatabase(stringsPurchase[5]);
        return new Purchase(localDateTime, good, buyer, seller);
    }

    @Override
    public void load() throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(name));

        final PurchaseHistory purchaseHistory = (PurchaseHistory) object;


        bufferedReader.close();
    }
}
