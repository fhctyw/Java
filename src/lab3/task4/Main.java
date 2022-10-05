package lab3.task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(final String[] args) {

        final Resources resources = new Resources();
        final Thread th1 = new CalcThread(resources, 10, 100);
        final Thread th2 = new CalcThread(resources, 15, 50);
        final Thread th3 = new CalcThread(resources, 20, 120);

        th1.start();
        th2.start();
        th3.start();

        final Resources resources1 = new Resources();
        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new ArithmeticService(resources1, 12, 110));
        executorService.execute(new ArithmeticService(resources1, 5, 200));
        executorService.execute(new ArithmeticService(resources1, 25, 20));

        executorService.shutdown();

        try {
            Thread.sleep(3000);
        } catch (final InterruptedException e) {

        }
        System.out.println("resource.number = " + resources.number);
        System.out.println("resource1.number = " + resources1.number);
    }
}
