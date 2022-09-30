package lab3.task1.menu;

import lab3.task1.store.Store;
import lab3.task1.store.hr.human.Buyer;
import lab3.task1.store.hr.human.Customer;
import lab3.task1.store.hr.service.PurchaseHistoryChecker;
import lab3.task1.store.report.NameIsEmptyException;
import lab3.task1.store.report.PriceZeroException;
import lab3.task1.store.report.Report;
import lab3.task1.store.service.StoreService;
import lab3.task1.store.storage.Good;
import lab3.task1.store.storage.service.StorageCheck;
import lab3.task1.store.storage.service.StorageGet;
import lab3.task1.store.storage.service.StoragePut;
import lab3.task1.store.storage.service.StorageScan;
import lab3.task1.store.workers.human.Cashier;
import lab3.task1.store.workers.human.Seller;
import lab3.task1.store.workers.service.SellerService;
import lab3.task1.store.workers.service.WorkerChecker;
import lab3.task1.store.workers.service.WorkerGet;
import lab3.task1.store.workers.service.WorkerPut;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Menu {
    private boolean run;
    final private Store store;
    final private List<Buyer> buyers;

    public Menu() {
        this.buyers = new ArrayList<Buyer>();
        this.store = StoreService.emptyStore();
        this.run = true;
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

    private void getPurchaseHistory() {
        System.out.println(store.getPurchaseHistory());
    }

    public void printMenuTypeDatabase() {
        final TypeDatabase[] values = TypeDatabase.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(i + " " + values[i].name());
        }
        System.out.println();
    }

    public TypeDatabase getTypeDatabaseIndex() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Choose type of database: ");
        final int indexTypeDatabase = scanner.nextInt();
        System.out.println();
        TypeDatabase typeDatabase;
        try {
            typeDatabase = TypeDatabase.values()[indexTypeDatabase];
        } catch (final IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println(ConsoleColors.RED + "Invalid type database index" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN_BOLD + "You should write in the range from 0 to " + (TypeDatabase.values().length - 1) + ConsoleColors.RESET + '\n');
            typeDatabase = null;
        }
        return typeDatabase;
    }

//    private Object loadOneDatabase(final String typeDatabaseMessage) {
//        final Scanner scanner = new Scanner(System.in);
//        System.out.print("Name database of " + ConsoleColors.BLUE_BOLD + typeDatabaseMessage + ConsoleColors.RESET + ": ");
//        final String name = scanner.nextLine();
//        final FileDatabase fileDatabase = new FileDatabase(name);
//        final Object database = fileDatabase.load();
//        if (database == null) {
//            System.out.println();
//            System.out.println(ConsoleColors.RED_BOLD + "database is null" + ConsoleColors.RESET);
//            System.out.println();
//        }
//        return database;
//    }
//
//    public void loadDatabase() {
//        printMenuTypeDatabase();
//        final TypeDatabase typeDatabase = getTypeDatabaseIndex();
//        switch (typeDatabase) {
//            case STORAGE_DATABASE:
//                this.storage = (Storage) loadOneDatabase("Storage");
//                break;
//            case HUMAN_RESOURES_DATABASE:
//                this.workers = (Workers) loadOneDatabase("Human resoures");
//                break;
//            case PURCHASE_HISTORY_DATABASE:
//                this.purchaseHistory = (PurchaseHistory) loadOneDatabase("Purchase history");
//                break;
//        }
//    }
//
//    private void saveOneDatabase(final Object database, final String typeDatabaseMessage) {
//        final Scanner scanner = new Scanner(System.in);
//        System.out.print("Name database of " + ConsoleColors.BLUE_BOLD + typeDatabaseMessage + ConsoleColors.RESET + ": ");
//        final String name = scanner.nextLine();
//        final FileDatabase fileDatabase = new FileDatabase(name);
//        if (!fileDatabase.save(database)) {
//            System.out.println(ConsoleColors.RED + "database loading exception" + ConsoleColors.RESET);
//        }
//    }
//
//    public void saveDatabase() {
//        printMenuTypeDatabase();
//        final TypeDatabase typeDatabase = getTypeDatabaseIndex();
//        switch (typeDatabase) {
//            case STORAGE_DATABASE:
//                saveOneDatabase(this.storage, "Storage");
//                break;
//            case HUMAN_RESOURES_DATABASE:
//                saveOneDatabase(this.workers, "Human resoures");
//                break;
//            case PURCHASE_HISTORY_DATABASE:
//                saveOneDatabase(this.purchaseHistory, "Purchase history");
//                break;
//        }
//    }

    public void infoDatabase() {
        final StorageCheck storageCheck = new StorageCheck(store.getStorage());
        System.out.println("Storage = " + ((storageCheck.exist())
                ? ConsoleColors.GREEN_BOLD + "available" + ConsoleColors.RESET
                : ConsoleColors.RED_BOLD + "not available" + ConsoleColors.RESET));
        if (storageCheck.exist()) {
            System.out.println("good count = " + storageCheck.count());
        }

        final WorkerChecker workerChecker = new WorkerChecker(store.getWorkers());
        System.out.println("Human resources = " + ((workerChecker.exist())
                ? ConsoleColors.GREEN_BOLD + "available" + ConsoleColors.RESET
                : ConsoleColors.RED_BOLD + "not available" + ConsoleColors.RESET));
        if (workerChecker.exist()) {
            System.out.println("worker count = " + workerChecker.count());
        }
        final PurchaseHistoryChecker purchaseHistoryChecker = new PurchaseHistoryChecker(store.getPurchaseHistory());
        System.out.println("Purchase history = " + ((purchaseHistoryChecker.exist())
                ? ConsoleColors.GREEN_BOLD + "available" + ConsoleColors.RESET
                : ConsoleColors.RED_BOLD + "not available" + ConsoleColors.RESET));
        if (purchaseHistoryChecker.exist()) {
            System.out.println("purchase history count = " + purchaseHistoryChecker.count());
        }
        System.out.println();
    }

    public void getGood() {
        final StorageGet storageGet = new StorageGet(store.getStorage());
        System.out.println("[0] get good by uuid");
        System.out.println("[1] get good by name");
        final int choose = getChoose();
        final Scanner scanner = new Scanner(System.in);
        switch (choose) {
            case 0:
                System.out.print("Enter uuid(in hex format) = ");
                final String stringUuid = scanner.nextLine();
                System.out.println(storageGet.get(UUID.fromString(stringUuid)));
                break;
            case 1:
                System.out.print("Enter name of good = ");
                final String nameGood = scanner.nextLine();
                final StorageScan storageScan = new StorageScan(store.getStorage());
                final UUID uuid = storageScan.scanByName(nameGood);
                System.out.println(storageGet.get(uuid));
                break;
        }
    }

    public void addGood() {
        final StoragePut storagePut = new StoragePut(store.getStorage());
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of good = ");
        final String nameGood = scanner.nextLine();

        System.out.print("Enter price of good = ");
        final double priceGood = scanner.nextDouble();

        System.out.print("Enter count = ");
        final int countGood = scanner.nextInt();
        final Report report;
        if (countGood == 1) {
            report = storagePut.put(new Good(nameGood, priceGood));
        } else {
            final List<Good> goods = new ArrayList<Good>();
            for (int i = 0; i < countGood; i++) {
                goods.add(new Good(nameGood, priceGood));
            }
            report = storagePut.put(goods);
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
        final int indexBuyer = scanner.nextInt();

        System.out.print("Enter index buyer = ");
        final int indexSeller = scanner.nextInt();


        final UUID uuidGood = UUID.fromString(stringUuidGood);
        final StorageGet storageGet = new StorageGet(store.getStorage());
        final Good good = storageGet.get(uuidGood);

        final WorkerGet workerGet = new WorkerGet(store.getWorkers().getEmployers(Seller.class));
        final Seller seller = (Seller) workerGet.get(indexSeller);

        final Buyer buyer = buyers.get(indexBuyer);

        final SellerService sellerService = new SellerService(store.getPurchaseHistory());
        sellerService.sell(seller, buyer, good);
    }

    public void stopStore() {
        setRun(false);
    }

    public void getGoods() {
        final StorageGet storageGet = new StorageGet(store.getStorage());
        storageGet.getAllGoods().forEach(System.out::println);
        System.out.println();
    }

    public void addCashier() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name = ");
        final String nameCashier = scanner.nextLine();
        System.out.print("Enter salary = ");
        final int salaryCashier = scanner.nextInt();
        final WorkerPut workerPut = new WorkerPut(store.getWorkers());
        workerPut.put(new Cashier(store.getPurchaseHistory(), nameCashier, salaryCashier));
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
