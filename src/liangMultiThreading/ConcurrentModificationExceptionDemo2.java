package liangMultiThreading;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ConcurrentModificationExceptionDemo2 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        // Thread 1: Modify the set
        Thread thread1 = new Thread(() -> {
            int i = 0;
            while (true) {
                synchronized (set) {
                    set.add(i++);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Thread 2: Traverse the set
        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (set) {
                    Iterator<Integer> iterator = set.iterator();
                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
