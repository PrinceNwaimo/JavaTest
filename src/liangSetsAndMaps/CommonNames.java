package liangSetsAndMaps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CommonNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        String filename = scanner.nextLine();

        Set<String> boyNames = new HashSet<>();
        Set<String> girlNames = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length >= 3) {
                    boyNames.add(parts[1]);
                    girlNames.add(parts[2]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
            return;
        }

        Set<String> commonNames = new HashSet<>(boyNames);
        commonNames.retainAll(girlNames);

        if (commonNames.isEmpty()) {
            System.out.println("No common names found.");
        } else {
            System.out.println("Common names:");
            for (String name : commonNames) {
                System.out.println(name);
            }
        }
    }
}
