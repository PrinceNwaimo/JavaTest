package liang10;

public class MyString1 {
    private char[] chars;

    public MyString1(char[] chars) {
        this.chars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            this.chars[i] = chars[i];
        }
    }

    public char charAt(int index) {
        if (index < 0 || index >= chars.length) {
            throw new StringIndexOutOfBoundsException("Index out of range");
        }
        return chars[index];
    }

    public int length() {
        return chars.length;
    }

    public MyString1 substring(int begin, int end) {
        if (begin < 0 || end > chars.length || begin > end) {
            throw new StringIndexOutOfBoundsException("Index out of range");
        }
        char[] substringChars = new char[end - begin];
        for (int i = begin; i < end; i++) {
            substringChars[i - begin] = chars[i];
        }
        return new MyString1(substringChars);
    }

    public MyString1 toLowerCase() {
        char[] lowerCaseChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                lowerCaseChars[i] = (char) (chars[i] + 'a' - 'A');
            } else {
                lowerCaseChars[i] = chars[i];
            }
        }
        return new MyString1(lowerCaseChars);
    }

    public boolean equals(MyString1 s) {
        if (chars.length != s.length()) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static MyString1 valueOf(int i) {
        return new MyString1(String.valueOf(i).toCharArray());
    }

    @Override
    public String toString() {
        return new String(chars);
    }

    public static void main(String[] args) {
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        MyString1 myString = new MyString1(chars);
        System.out.println("charAt(0): " + myString.charAt(0));
        System.out.println("length(): " + myString.length());
        System.out.println("substring(1, 4): " + myString.substring(1, 4));
        System.out.println("toLowerCase(): " + myString.toLowerCase());
        MyString1 myString2 = new MyString1(chars);
        System.out.println("equals(): " + myString.equals(myString2));
        System.out.println("valueOf(123): " + MyString1.valueOf(123));
    }
}
