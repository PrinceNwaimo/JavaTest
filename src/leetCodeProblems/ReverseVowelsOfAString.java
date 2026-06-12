package leetCodeProblems;
import java.util.*;

public class ReverseVowelsOfAString {
    private Set<Character> vowels;

    public ReverseVowelsOfAString() {
        vowels = new HashSet<>(Arrays.asList(
                'a','e','i','o','u','A','E','I','O','U'
        ));
    }

    public String reverseVowels(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            if (!vowels.contains(chars[i])) {
                i++;
                continue;
            }
            if (!vowels.contains(chars[j])) {
                j--;
                continue;
            }
            // swap vowels
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString solver = new ReverseVowelsOfAString();

        String s1 = "CreatingImpact";
        String s2 = "ProblemLeetCode";

        System.out.println(solver.reverseVowels(s1));
        System.out.println(solver.reverseVowels(s2));
    }
}
