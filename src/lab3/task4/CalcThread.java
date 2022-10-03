package lab3.task4;

public class CalcThread extends Thread {
    final private Resources resources;
    final int iterations;
    final int milliseconds;
    public CalcThread(final Resources resources) {
        this.resources = resources;
        this.iterations = 10;
        this.milliseconds = 100;
    }

    public CalcThread(final Resources resources, final int iterations, final int milliseconds) {
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
                    System.out.println("Thread[" + getName() + "] = " + resources.number);
                    Thread.sleep(milliseconds);
                }
            } catch (final InterruptedException interruptedException) {

            }
            System.out.println("Thread[" + getName() + "] has finished with " + resources.number);
        }
    }
}
