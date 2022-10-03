package lab3.task1.menu;

import lab3.task1.store.Store;
import lab3.task1.store.hr.Purchase;
import lab3.task1.store.hr.human.Buyer;
import lab3.task1.store.hr.human.Customer;
import lab3.task1.store.hr.service.PurchaseHistoryService;
import lab3.task1.store.report.NameIsEmptyException;
import lab3.task1.store.report.PriceZeroException;
import lab3.task1.store.report.Report;
import lab3.task1.store.service.StoreService;
import lab3.task1.store.service.StoreTask3;
import lab3.task1.store.storage.Good;
import lab3.task1.store.storage.service.StorageService;
import lab3.task1.store.workers.human.Cashier;
import lab3.task1.store.workers.human.Seller;
import lab3.task1.store.workers.service.WorkerService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {
    private boolean run;
    final private Store store;
    final private List<Buyer> buyers;

    public Menu() {
        this.buyers = new ArrayList<Buyer>();
        this.store = StoreService.emptyStore();
        this.run = true;
    }

    public void setDefaultStore() {

        final StorageService storageService = new StorageService(store.getStorage());
        storageService.putNoReport(Stream.of(
                new Good("table", 13),
                new Good("table", 13),
                new Good("table", 13),
                new Good("phone", 1300),
                new Good("phone", 1300),
                new Good("computer mouse", 300),
                new Good("computer mouse", 300),
                new Good("computer mouse", 300),
                new Good("Cake", 20),
                new Good("Cake", 20),
                new Good("Cake", 20)
        ).collect(Collectors.toList()));

        final WorkerService workerService = new WorkerService(store.getWorkers());
        workerService.addWorker(new Cashier("Alex", 9000));
        workerService.addWorker(new Cashier("Jack", 11300));

        buyers.add(new Customer("Max", 3000));
        buyers.add(new Customer("Amanda", 5300));

        final StoreService storeService = new StoreService(store);
        storeService.sellGood((Seller) store.getWorkers().getEmployees().get(1), buyers.get(1), ((Good) store.getStorage().getGoods().values().toArray()[3]).getUuid());

        storeService.sellGood((Seller) store.getWorkers().getEmployees().get(1), buyers.get(1), ((Good) store.getStorage().getGoods().values().toArray()[6]).getUuid());
        storeService.sellGood((Seller) store.getWorkers().getEmployees().get(1), buyers.get(1), ((Good) store.getStorage().getGoods().values().toArray()[3]).getUuid());

        store.getPurchaseHistory().getPurchases().add(new Purchase(LocalDateTime.of(LocalDate.parse("2022-10-01"), LocalTime.MIN), new Good("fridge", 2000), buyers.get(0), (Seller) store.getWorkers().getEmployees().get(0)));
    }

    public void setRun(final boolean run) {
        this.run = run;
    }

    public void runMenu() {
        Operation operation;
        while (run) {
            printMenu();
            operation = getOperationIndex();
            if (operation == null) {
                continue;
            }
            processOperation(operation);
        }
    }

    private int getChoose() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Choose: ");
        final int index = scanner.nextInt();
        System.out.println();
        return index;
    }

    public void printMenu() {
        final Operation[] allOperations = Operation.values();
        for (int i = 0; i < Operation.values().length; i++) {
            System.out.println("[" + i + "]" + " " + allOperations[i]);
        }
        System.out.println();
    }

    public Operation getOperationIndex() {
        final int indexOperation = getChoose();
        Operation operation;
        try {
            operation = Operation.values()[indexOperation];
        } catch (final IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println(ConsoleColors.RED + "Invalid operation index" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN_BOLD + "You should write in the range from 0 to " + (Operation.values().length - 1) + ConsoleColors.RESET + '\n');
            operation = null;
        }
        return operation;
    }

    public void processOperation(final Operation operation) {
        switch (operation) {
            case INFO_DATABASE:
                infoDatabase();
                break;
            case GET_GOOD:
                getGood();
                break;
            case GET_GOODS:
                getGoods();
                break;
            case GET_SORT_GOODS:
                getSortGoods();
                break;
            case GET_AVG_PRICE:
                getAvgPrice();
                break;
            case GET_PURCHASE_HISTORY_BY:
                getPurchaseHistoryBy();
                break;
            case GET_GOODS_BY_BUYER:
                getGoodsByBuyer();
                break;
            case GET_POPULAR_GOOD:
                getPopularGood();
                break;
            case GET_MAX_PROFIT:
                getMaxProfit();
                break;
            case ADD_GOOD:
                addGood();
                break;
            case SELL_GOOD:
                sellGood();
                break;
            case ADD_CUSTOMER:
                addCustomer();
                break;
            case GET_WORKERS:
                getWorkers();
                break;
            case GET_PURCHASE_HISTORY:
                getPurchaseHistory();
                break;
            case STOP_STORE:
                stopStore();
                break;
            case GET_BUYER:
                getBuyer();
                break;
            case GET_BUYERS:
                getBuyers();
                break;
            case ADD_CASHIER:
                addCashier();
                break;
        }
    }

    private void getMaxProfit() {
        final StoreTask3 storeTask3 = new StoreTask3(store);
        System.out.println(storeTask3.getMaxProfitPerDate());
    }

    private void getPopularGood() {
        final StoreTask3 storeTask3 = new StoreTask3(store);
        System.out.println(storeTask3.getPopularGood());
    }

    private void getGoodsByBuyer() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name = ");
        final String customerName = scanner.nextLine();
        final Customer customer = (Customer) buyers.stream()
                .filter(e -> e.getClass() == Customer.class && ((Customer) e).getName().equals(customerName))
                .findFirst()
                .orElse(null);

        final StoreTask3 storeTask3 = new StoreTask3(store);
        storeTask3.getGoodsByBuyer(customer).forEach((k, v) -> System.out.println(k + " " + v));
    }

    private void getPurchaseHistoryBy() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name = ");
        final String customerName = scanner.nextLine();
        final Customer customer = (Customer) buyers.stream()
                .filter(e -> e.getClass() == Customer.class && ((Customer) e).getName().equals(customerName))
                .findFirst()
                .orElse(null);

        System.out.print("Enter first date = ");
        final LocalDateTime firstTime = LocalDateTime.of(LocalDate.parse(scanner.nextLine()), LocalTime.MIN);

        System.out.print("Enter second date = ");
        final LocalDateTime secondTime = LocalDateTime.of(LocalDate.parse(scanner.nextLine()), LocalTime.MAX);

        final StoreTask3 storeTask3 = new StoreTask3(store);
        storeTask3.getPurchaseHistoryPerBuyer(customer, firstTime, secondTime).getPurchases().forEach(System.out::println);
        System.out.println("Total expenses = " + storeTask3.getExpensePerBuyer(customer, firstTime, secondTime));
    }

    private void getAvgPrice() {
        final StoreTask3 storageSort = new StoreTask3(store);
        System.out.println("avg = " + storageSort.getAvgPrice());
    }

    private void getSortGoods() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("[0] Sort by name");
        System.out.println("[1] Sort by price");

        final int index = getChoose();
        final StoreTask3 storageSort = new StoreTask3(store);

        switch (index) {
            case 0:
                storageSort.sortByName().forEach(System.out::println);
                break;
            case 1:
                storageSort.sortByPrice().forEach(System.out::println);
                break;
        }
    }

    private void getPurchaseHistory() {
        System.out.println(store.getPurchaseHistory());
    }

    public void infoDatabase() {

        final StorageService storageService = new StorageService(store.getStorage());
        System.out.println("Storage = " + ((storageService.exist())
                ? ConsoleColors.GREEN_BOLD + "available" + ConsoleColors.RESET
                : ConsoleColors.RED_BOLD + "not available" + ConsoleColors.RESET));
        if (storageService.exist()) {
            System.out.println("good count = " + storageService.count());
        }

        final WorkerService workerService = new WorkerService(store.getWorkers());
        System.out.println("Human resources = " + ((workerService.exist())
                ? ConsoleColors.GREEN_BOLD + "available" + ConsoleColors.RESET
                : ConsoleColors.RED_BOLD + "not available" + ConsoleColors.RESET));
        if (workerService.exist()) {
            System.out.println("worker count = " + workerService.count());
        }
        final PurchaseHistoryService purchaseHistoryService = new PurchaseHistoryService(store.getPurchaseHistory());
        System.out.println("Purchase history = " + ((purchaseHistoryService.exist())
                ? ConsoleColors.GREEN_BOLD + "available" + ConsoleColors.RESET
                : ConsoleColors.RED_BOLD + "not available" + ConsoleColors.RESET));
        if (purchaseHistoryService.exist()) {
            System.out.println("purchase history count = " + purchaseHistoryService.count());
        }
        System.out.println();
    }

    public void getGood() {
        final StorageService storageService = new StorageService(store.getStorage());
        System.out.println("[0] get good by uuid");
        System.out.println("[1] get good by name");
        final int choose = getChoose();
        final Scanner scanner = new Scanner(System.in);
        switch (choose) {
            case 0:
                System.out.print("Enter uuid(in hex format) = ");
                final String stringUuid = scanner.nextLine();
                System.out.println(storageService.getGood(UUID.fromString(stringUuid)));
                break;
            case 1:
                System.out.print("Enter name of good = ");
                final String nameGood = scanner.nextLine();
                final UUID uuid = storageService.scanByName(nameGood);
                System.out.println(storageService.getGood(uuid));
                break;
        }
    }

    public void addGood() {
        final StorageService storageService = new StorageService(store.getStorage());
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of good = ");
        final String nameGood = scanner.nextLine();

        System.out.print("Enter price of good = ");
        final double priceGood = scanner.nextDouble();

        System.out.print("Enter count = ");
        final int countGood = scanner.nextInt();
        final Report report;
        if (countGood == 1) {
            report = storageService.putGood(new Good(nameGood, priceGood));
        } else {
            final List<Good> goods = new ArrayList<Good>();
            for (int i = 0; i < countGood; i++) {
                goods.add(new Good(nameGood, priceGood));
            }
            report = storageService.putGood(goods);
        }

        System.out.println(report);
        System.out.println("[0] Validate");
        System.out.println("[1] Don't validate");
        final int index = getChoose();
        if (index == 0) {
            try {
                report.validate();
                System.out.println(ConsoleColors.GREEN_BOLD + "validate" + ConsoleColors.RESET);
            } catch (final NameIsEmptyException | PriceZeroException e) {
                throw new RuntimeException(e);
            }
        }
        //= storagePut.put();
    }

    public void sellGood() {

        final Scanner scanner = new Scanner(System.in);

        System.out.print("Enter uuid good = ");
        final String stringUuidGood = scanner.nextLine();

        System.out.print("Enter index seller = ");
        final int indexSeller = scanner.nextInt();

        System.out.print("Enter index buyer = ");
        final int indexBuyer = scanner.nextInt();

        final UUID uuidGood = UUID.fromString(stringUuidGood);

        WorkerService workerService = new WorkerService(store.getWorkers());
        workerService = new WorkerService(workerService.getEmployers(Seller.class));
        final Seller seller = (Seller) workerService.getEmployer(indexSeller);

        final Buyer buyer = buyers.get(indexBuyer);

        final StoreService storeService = new StoreService(store);
        storeService.sellGood(seller, buyer, uuidGood);
    }

    public void stopStore() {
        setRun(false);
    }

    public void getGoods() {
        final StorageService storageService = new StorageService(store.getStorage());
        storageService.getAllGoods().forEach(System.out::println);
        System.out.println();
    }

    public void addCashier() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name = ");
        final String nameCashier = scanner.nextLine();
        System.out.print("Enter salary = ");
        final int salaryCashier = scanner.nextInt();
        final WorkerService workerService = new WorkerService(store.getWorkers());
        workerService.addWorker(new Cashier(nameCashier, salaryCashier));
    }

    public void getBuyer() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter index of buyer = ");
        final int index = scanner.nextInt();
        System.out.println();
        final Buyer buyer = buyers.get(index);
        System.out.println(buyer);
    }

    public void addCustomer() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name = ");
        final String nameCustomer = scanner.nextLine();
        System.out.print("Enter money = ");
        final int moneyCustomer = scanner.nextInt();
        buyers.add(new Customer(nameCustomer, moneyCustomer));
    }

    public void getBuyers() {
        buyers.forEach(System.out::println);
    }

    public void getWorkers() {
        System.out.println(store.getWorkers());
    }
}
