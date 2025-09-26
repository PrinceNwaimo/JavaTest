package liangSetsAndMaps;

import java.util.*;

public class WordOccurrence implements Comparable<WordOccurrence>{
    String word;
    int count;

    public WordOccurrence(String word, int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public int compareTo(WordOccurrence other) {
        return Integer.compare(this.count, other.count);
    }

    @Override
    public String toString() {
        return word + ": " + count;
    }
}

