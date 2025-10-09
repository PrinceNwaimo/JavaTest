package diettelStreams;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class CharacterSummary {
    public static void main(String[] args) {
        TreeMap<Character, Integer> map = new TreeMap<>();

        try (Scanner scanner = new Scanner(new File("example.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();
                for (char c : line.toCharArray()) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
