package liangMultiThreading;

public class DeadlockDemo {
    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        // Thread 1
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Holding lock 1 and lock 2...");
                }
            }
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock 2...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (lock1) {
                    System.out.println("Thread 2: Holding lock 1 and lock 2...");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
//Explanation1. We create two objects, lock1 and lock2, which will be used as locks.
//2. thread1 acquires lock1 and then waits for lock2.
//3. thread2 acquires lock2 and then waits for lock1.
//4. Since thread1 is holding lock1 and waiting for lock2, and thread2 is holding lock2 and waiting for lock1, a deadlock occurs.
//
//OutputThe program will output something like:
//
//
//Thread 1: Holding lock 1...
//Thread 2: Holding lock 2...
//Thread 1: Waiting for lock 2...
//Thread 2: Waiting for lock 1...
//
//
//And then it will hang, indicating a deadlock.
//
//How to avoid deadlockTo avoid deadlock, you can use the following strategies:
//
//1. Avoid nested locks: Try to avoid acquiring multiple locks in a nested manner.
//2. Use a lock hierarchy: Establish a lock hierarchy and always acquire locks in that order.
//3. Use a timeout: Use a timeout when acquiring a lock, and if the lock is not acquired within the timeout, release any held locks and retry.
//4. Use a deadlock detection algorithm: Use a deadlock detection algorithm to detect and recover from deadlocks.