package diettelStreams;

import java.util.Arrays;

public class TwoDimensionalArrays2 {
    public static void main(String[] args) {
        int[][] grades = {
                {90, 80, 70},
                {95, 85, 75},
                {98, 88, 78},
                {92, 82, 72},
                {96, 86, 76},
                {91, 81, 71},
                {94, 84, 74},
                {97, 87, 77},
                {93, 83, 73},
                {99, 89, 79}
        };

        Arrays.stream(grades)
                .map(row -> Arrays.stream(row).average().orElse(0.0))
                .forEach(average -> System.out.printf("Average: %.2f%n", average));
    }
}
