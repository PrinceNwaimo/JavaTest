package liang10;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewStringSplitMethod {
    public static String[] split(String s, String regex) {
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile("(" + regex + ")");
        Matcher matcher = pattern.matcher(s);
        int start = 0;
        while (matcher.find()) {
            if (start < matcher.start()) {
                result.add(s.substring(start, matcher.start()));
            }
            result.add(matcher.group());
            start = matcher.end();
        }
        if (start < s.length()) {
            result.add(s.substring(start));
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] result1 = split("ab#12#453", "#");
        for (String str : result1) {
            System.out.print(str + " ");
        }
        System.out.println();

        String[] result2 = split("a?b?gf#e", "[?#]");
        for (String str : result2) {
            System.out.print(str + " ");
        }
    }
}
