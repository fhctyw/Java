package lab3.task1.store.service;

import lab3.task1.store.Store;
import lab3.task1.store.hr.Purchase;
import lab3.task1.store.hr.PurchaseHistory;
import lab3.task1.store.hr.human.Buyer;
import lab3.task1.store.storage.Good;
import lab3.task1.tool.Pair;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StoreTask3 extends StoreService {
    public StoreTask3(final Store store) {
        super(store);
    }

    public Stream<Good> sortByName() {
        return store.getStorage()
                .getGoods()
                .values()
                .stream()
                .sorted(Comparator.comparing(Good::getName));
    }

    public Stream<Good> sortByPrice() {
        return store.getStorage()
                .getGoods()
                .values()
                .stream()
                .sorted(Comparator.comparingDouble(Good::getPrice));
    }

    public double getAvgPrice() {
        return store.getStorage()
                .getGoods()
                .values()
                .stream()
                .mapToDouble(Good::getPrice)
                .average().orElse(-1);
    }

    public PurchaseHistory getPurchaseHistoryPerBuyer(final Buyer buyer, final LocalDateTime firstTime, final LocalDateTime secondTime) {
        if (firstTime.isAfter(secondTime)) {
            throw new InvalidParameterException();
        }
        return new PurchaseHistory(store
                .getPurchaseHistory()
                .getPurchases()
                .stream()
                .filter(e -> e.getDateTime().isAfter(firstTime) && e.getDateTime().isBefore(secondTime) && e.getBuyer().equals(buyer))
                .collect(Collectors.toList())
        );
    }

    public double getExpensePerBuyer(final Buyer buyer, final LocalDateTime firstTime, final LocalDateTime secondTime) {
        return getPurchaseHistoryPerBuyer(buyer, firstTime, secondTime)
                .getPurchases()
                .stream()
                .mapToDouble(e -> e.getGood().getPrice())
                .sum();
    }

    public long getGoodCountPurchaseHistory(final Good good, final Buyer buyer) {
        return store.getPurchaseHistory()
                .getPurchases()
                .stream()
                .filter(e -> e.getBuyer().equals(buyer) && e.getGood().getName().equals(good.getName()) && e.getGood().getPrice() == good.getPrice())
                .count();
    }

    public Map<Good, Integer> getGoodsByBuyer(final Buyer buyer) {
        final Map<Good, Integer> map = new HashMap<Good, Integer>();
        store.getPurchaseHistory()
                .getPurchases()
                .stream()
                .filter(e -> e.getBuyer().equals(buyer))
                .forEach(e -> map.put(e.getGood(), (int) getGoodCountPurchaseHistory(e.getGood(), buyer)));
        return map;
    }

    public int getSellGoodCount(final Good good) {
        return (int) store.getPurchaseHistory()
                .getPurchases()
                .stream()
                .filter(e -> e.getGood().getName().equals(good.getName()) && e.getGood().getPrice() == good.getPrice())
                .count();
    }

    public Good getPopularGood() {
        return store.getStorage()
                .getGoods()
                .values()
                .stream()
                .max(((g1, g2) -> getSellGoodCount(g1) - getSellGoodCount(g2)))
                .get();
    }

    private double getProfitByPurchaseHistory(final List<Purchase> purchases) {
        return purchases.stream()
                .mapToDouble(e -> e.getGood().getPrice())
                .sum();
    }

    public Map<LocalDate, Double> getMapProfitPerDate() {
        final Map<LocalDate, List<Purchase>> map = store.getPurchaseHistory()
                .getPurchases()
                .stream()
                .collect(Collectors.groupingBy(e -> e.getDateTime().toLocalDate()));

        return map.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> getProfitByPurchaseHistory(e.getValue())));
    }

    public Pair<LocalDate, Double> getMaxProfitPerDate() {
        return new Pair<>(getMapProfitPerDate()
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .get());
    }
}
