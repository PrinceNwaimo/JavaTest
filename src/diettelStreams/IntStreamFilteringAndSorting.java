package diettelStreams;

import java.security.SecureRandom;

public class IntStreamFilteringAndSorting {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        random.ints(50, 1, 1000)
                .filter(n -> n % 2 != 0)
                .sorted()
                .forEach(System.out::println);
    }
}
