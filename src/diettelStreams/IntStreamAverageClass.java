package diettelStreams;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class IntStreamAverageClass {
    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter grade (-1 to stop): ");
            int grade = scanner.nextInt();

            if (grade == -1) {
                break;
            }

            grades.add(grade);
        }

        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            double average = grades.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0.0);

            System.out.printf("Class average: %.2f%n", average);
        }
    }
}
