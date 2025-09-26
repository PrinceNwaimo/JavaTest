package liangSetsAndMaps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BabyNameRankings {
    private Map<Integer, Map<String, Integer>> boyRankings;
    private Map<Integer, Map<String, Integer>> girlRankings;

    public BabyNameRankings() {
        boyRankings = new HashMap<>();
        girlRankings = new HashMap<>();

        for (int year = 2001; year <= 2010; year++) {
            boyRankings.put(year, new HashMap<>());
            girlRankings.put(year, new HashMap<>());
            readRankings(year);
        }
    }

    private void readRankings(int year) {
        try (BufferedReader reader = new BufferedReader(new FileReader("babynamesranking" + year + ".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length >= 3) {
                    int rank = Integer.parseInt(parts[0]);
                    String boyName = Arrays.toString(parts);
                    String girlName = Arrays.toString(parts);

                    boyRankings.get(year).put(boyName, rank);
                    girlRankings.get(year).put(girlName, rank);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file for year " + year);
        }
    }

    public void searchRankings() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter year (2001-2010): ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        System.out.print("Enter gender (M/F): ");
        String gender = scanner.nextLine().trim().toUpperCase();

        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();

        if (gender.equals("M")) {
            if (boyRankings.get(year).containsKey(name)) {
                System.out.println(name + " ranked " + boyRankings.get(year).get(name) + " in " + year + " for boys.");
            } else {
                System.out.println(name + " is not ranked in " + year + " for boys.");
            }
        } else if (gender.equals("F")) {
            if (girlRankings.get(year).containsKey(name)) {
                System.out.println(name + " ranked " + girlRankings.get(year).get(name) + " in " + year + " for girls.");
            } else {
                System.out.println(name + " is not ranked in " + year + " for girls.");
            }
        } else {
            System.out.println("Invalid gender.");
        }
    }

    public static void main(String[] args) {
        BabyNameRankings rankings = new BabyNameRankings();
        rankings.searchRankings();
    }
}
