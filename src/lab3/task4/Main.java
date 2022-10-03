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

        final int iterations = 10;
        final int milliseconds = 100;

        final Resources resources1 = new Resources();
        final Runnable runnable = () -> {
            try {
                for (int i = 0; i < iterations; i++) {
                    resources.number++;
                    System.out.println("Thread[" + Thread.currentThread().getName() + "] = " + resources.number);
                    Thread.sleep(milliseconds);
                }
            } catch (final InterruptedException interruptedException) {

            }
        };

        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(runnable);
    }
}
