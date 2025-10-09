package diettelStreams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {
    public static void main(String[] args) {
        String[] strings = {"Red","Orange","Yellow","Green","Blue","Indigo","Violet","Black"};
        System.out.printf("Original strings: %s%n", Arrays.asList(strings));
        System.out.printf("strings in uppercase: %s%n", Arrays.stream(strings).map(String::toUpperCase).collect(Collectors.toList()));
        System.out.printf("Strings less than n sorted ascending: %s%n", Arrays.stream(strings).filter(s->s.compareToIgnoreCase("n") < 0).sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList()));
        System.out.printf("Strings less than n sorted descending: %s%n", Arrays.stream(strings).filter(s-> s.compareToIgnoreCase("n") < 0).sorted(String.CASE_INSENSITIVE_ORDER.reversed()).collect(Collectors.toList()));


    }
}
