package liangMultiThreading;

public class IntegerWrapper {
    private int value;

    public IntegerWrapper(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public synchronized void increment() {
        value++;
    }
}



// ThreadExample.java
class ThreadExample implements Runnable {
    private IntegerWrapper sum;

    public ThreadExample(IntegerWrapper sum) {
        this.sum = sum;
    }

    @Override
    public void run() {
        sum.increment();
    }

    public static void main(String[] args) throws InterruptedException {
        int numThreads = 1000;

        // Without synchronization
        IntegerWrapper sumWithoutSync = new IntegerWrapper(0);
        Thread[] threadsWithoutSync = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threadsWithoutSync[i] = new Thread(new ThreadExample(sumWithoutSync));
            threadsWithoutSync[i].start();
        }
        for (Thread thread : threadsWithoutSync) {
            thread.join();
        }
        System.out.println("Sum without synchronization: " + sumWithoutSync.getValue());

        // With synchronization
        IntegerWrapper sumWithSync = new IntegerWrapper(0);
        Thread[] threadsWithSync = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threadsWithSync[i] = new Thread(new ThreadExample(sumWithSync));
            threadsWithSync[i].start();
        }
        for (Thread thread : threadsWithSync) {
            thread.join();
        }
        System.out.println("Sum with synchronization: " + sumWithSync.getValue());
    }
}
