package liangSetsAndMaps;

import java.util.*;

public class CountOccurrenceOfWords2{
    public static void main(String[] args) {
        String text = "Good morning. Have a good class. " +
                "Have a good visit. Have fun!";

        Map<String, Integer> map = new HashMap<>();
        String[] words = text.split("[\\s+\\p{Punct}]");

        for (String word : words) {
            if (word.length() > 0) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<WordOccurrence> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }

        Collections.sort(list);

        for (WordOccurrence occurrence : list) {
            System.out.println(occurrence);
        }
    }
}
