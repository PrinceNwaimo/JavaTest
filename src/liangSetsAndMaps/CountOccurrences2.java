package liangSetsAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountOccurrences2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();

        while (true) {
            System.out.print("Enter an integer (0 to stop): ");
            int number = scanner.nextInt();

            if (number == 0) {
                break;
            }

            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        if (map.isEmpty()) {
            System.out.println("No numbers were entered.");
            return;
        }

        int maxCount = 0;
        for (int count : map.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        System.out.println("The number(s) with the most occurrences:");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                System.out.println(entry.getKey() + " occurred " + maxCount + " time(s).");
            }
        }
    }
}
