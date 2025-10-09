package diettelStreams;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DieRolls {
    public static void main(String[] args) {
        int numRolls = 60_000_000;

        // Using SecureRandom
        Instant startSecureRandom = Instant.now();
        new SecureRandom().ints(numRolls, 1, 7)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((face, frequency) -> System.out.printf("%d: %d%n", face, frequency));
        Instant endSecureRandom = Instant.now();
        Duration durationSecureRandom = Duration.between(startSecureRandom, endSecureRandom);
        System.out.printf("Time taken using SecureRandom: %d milliseconds%n", durationSecureRandom.toMillis());

        // Using Random
        Instant startRandom = Instant.now();
        new Random().ints(numRolls, 1, 7)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((face, frequency) -> System.out.printf("%d: %d%n", face, frequency));
        Instant endRandom = Instant.now();
        Duration durationRandom = Duration.between(startRandom, endRandom);
        System.out.printf("Time taken using Random: %d milliseconds%n", durationRandom.toMillis());
    }
}
