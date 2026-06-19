package leetCodeProblems;

import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.equals("") && t.equals("")) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapST.containsKey(c1)) {
                if (mapST.get(c1) != c2) {
                    return false;
                }
            } else {
                if (mapTS.containsKey(c2)) {
                    return false; // c2 already mapped from another char
                }
                mapST.put(c1, c2);
                mapTS.put(c2, c1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings iso = new IsomorphicStrings();

        System.out.println(iso.isIsomorphic("egg", "add"));
        System.out.println(iso.isIsomorphic("foo", "bar"));
        System.out.println(iso.isIsomorphic("paper", "title"));
    }
}
