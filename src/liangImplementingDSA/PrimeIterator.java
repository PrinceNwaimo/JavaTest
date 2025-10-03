package liangImplementingDSA;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator<Integer>{
    private int limit;
    private int current = 1;

    public PrimeIterator(int limit) {
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
        do {
            current++;
        } while (current <= limit && !isPrime(current));
        return current;
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeIterator iterator = new PrimeIterator(100000);
        System.out.println("Prime numbers less than or equal to 100000:");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
