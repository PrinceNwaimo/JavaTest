package liangExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BabyNameRanking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        System.out.print("Enter the gender (M/F): ");
        String gender = scanner.next().toUpperCase();
        System.out.print("Enter the name: ");
        String name = scanner.next();
        scanner.close();

        String filename = "babynameranking" + year + ".txt";
        Map<String, Integer> nameRankings = readNameRankings(filename, gender);

        if (nameRankings.containsKey(name)) {
            int ranking = nameRankings.get(name);
            System.out.println(name + " is ranked #" + ranking + " in year " + year);
        } else {
            System.out.println("The name " + name + " is not ranked in year " + year);
        }
    }

    private static Map<String, Integer> readNameRankings(String filename, String gender) {
        Map<String, Integer> nameRankings = new HashMap<>();

        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String[] line = fileScanner.nextLine().split("\\s+");
                int ranking = Integer.parseInt(line[0]);
                if (gender.equals("M")) {
                    nameRankings.put(line[1], ranking);
                } else {
                    nameRankings.put(line[3], ranking);
                }
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }

        return nameRankings;
    }
}
