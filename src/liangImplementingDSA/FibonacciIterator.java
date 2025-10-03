package liangImplementingDSA;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FibonacciIterator implements Iterator<Integer> {
    private int limit;
    private int current = 0;
    private int next = 1;

    public FibonacciIterator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return current <= limit;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = current;
        int sum = current + next;
        current = next;
        next = sum;
        return result;
    }

    public static void main(String[] args) {
        FibonacciIterator iterator = new FibonacciIterator(100000);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
