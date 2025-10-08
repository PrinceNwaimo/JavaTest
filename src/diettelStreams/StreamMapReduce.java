package diettelStreams;

import java.util.stream.IntStream;

public class StreamMapReduce {
    public static void main(String[] args) {
        int total = 0;
        for (int number = 2; number <= 20; number += 2) {
            total += number;
        }
        System.out.println(total);
        System.out.printf("Sum of the even numbers from 2 through 20 is : %d%n", IntStream.rangeClosed(1,10).map((int x) -> {return x * 2;}).sum());
        System.out.printf("Sum of the even numbers from 2 through 20 is : %d%n", IntStream.rangeClosed(1,10).map((int x) ->  x * 2).sum());
    }
}