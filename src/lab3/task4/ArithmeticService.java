package lab3.task4;

public class ArithmeticService implements Runnable {
    final private Resources resources;
    final int iterations;
    final int milliseconds;

    public ArithmeticService(final Resources resources) {
        this.resources = resources;
        this.iterations = 10;
        this.milliseconds = 100;
    }

    public ArithmeticService(final Resources resources, final int iterations, final int milliseconds) {
        this.resources = resources;
        this.iterations = iterations;
        this.milliseconds = milliseconds;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < iterations; i++) {
                    resources.number++;
                    System.out.println("Thread[" + Thread.currentThread().getName() + "] = " + resources.number);
                    Thread.sleep(milliseconds);
                }
            } catch (final InterruptedException interruptedException) {

            }
            System.out.println("Thread[" + Thread.currentThread().getName() + "] has finished with " + resources.number);
        }
    }
}
