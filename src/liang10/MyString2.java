package liang10;

public class MyString2 {
    private String str;

    public MyString2(String s) {
        this.str = s;
    }

    public int compare(String s) {
        int len1 = str.length();
        int len2 = s.length();
        int len = Math.min(len1, len2);
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != s.charAt(i)) {
                return str.charAt(i) - s.charAt(i);
            }
        }
        return len1 - len2;
    }

    public MyString2 substring(int begin) {
        if (begin < 0 || begin > str.length()) {
            throw new StringIndexOutOfBoundsException("Index out of range");
        }
        return new MyString2(str.substring(begin));
    }

    public MyString2 toUpperCase() {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append((char) (c - 'a' + 'A'));
            } else {
                sb.append(c);
            }
        }
        return new MyString2(sb.toString());
    }

    public char[] toChars() {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }

    public static MyString2 valueOf(boolean b) {
        return new MyString2(String.valueOf(b));
    }

    @Override
    public String toString() {
        return str;
    }

    public static void main(String[] args) {
        MyString2 myString = new MyString2("Hello");
        System.out.println("compare(): " + myString.compare("Hello"));
        System.out.println("substring(1): " + myString.substring(1));
        System.out.println("toUpperCase(): " + myString.toUpperCase());
        System.out.println("toChars(): " + java.util.Arrays.toString(myString.toChars()));
        System.out.println("valueOf(true): " + MyString2.valueOf(true));
    }
}
