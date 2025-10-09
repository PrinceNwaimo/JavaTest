package diettelStreams;

import java.util.Arrays;

public class TwoDimensionalArrays {
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

        double average = Arrays.stream(grades)
                .flatMapToInt(Arrays::stream)
                .average()
                .orElse(0.0);

        System.out.printf("Average grade: %.2f%n", average);
    }
}
