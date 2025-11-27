package diettelConcurrency;

import java.time.Duration;
import java.text.NumberFormat;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TimeData {
    public Instant start;
    public Instant end;

    public double timeInSeconds() {
              return Duration.between(start, end).toMillis() / 1000.0;
           }
}





