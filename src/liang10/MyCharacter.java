package liang10;

public class MyCharacter {
    private char ch;

    public MyCharacter(char ch) {
        this.ch = ch;
    }

    public static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static boolean isLetter(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    public static boolean isLetterOrDigit(char ch) {
        return isLetter(ch) || isDigit(ch);
    }

    public static boolean isLowerCase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public static boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    public static char toLowerCase(char ch) {
        if (isUpperCase(ch)) {
            return (char) (ch + 'a' - 'A');
        } else {
            return ch;
        }
    }

    public static char toUpperCase(char ch) {
        if (isLowerCase(ch)) {
            return (char) (ch - 'a' + 'A');
        } else {
            return ch;
        }
    }

    public char charValue() {
        return ch;
    }

    public static void main(String[] args) {
        System.out.println("isDigit('5'): " + MyCharacter.isDigit('5'));
        System.out.println("isLetter('a'): " + MyCharacter.isLetter('a'));
        System.out.println("isLetterOrDigit('A'): " + MyCharacter.isLetterOrDigit('A'));
        System.out.println("isLowerCase('B'): " + MyCharacter.isLowerCase('B'));
        System.out.println("isUpperCase('b'): " + MyCharacter.isUpperCase('b'));
        System.out.println("toLowerCase('C'): " + MyCharacter.toLowerCase('C'));
        System.out.println("toUpperCase('d'): " + MyCharacter.toUpperCase('d'));
        MyCharacter myChar = new MyCharacter('E');
        System.out.println("charValue(): " + myChar.charValue());
    }
}
