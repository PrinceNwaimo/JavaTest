package liang10;

public class MyStringBuilder1 {
    private char[] chars;
    private int size;

    public MyStringBuilder1(String s) {
        chars = new char[s.length() * 2];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        size = s.length();
    }

    public MyStringBuilder1 append(MyStringBuilder1 s) {
        ensureCapacity();
        for (int i = 0; i < s.size; i++) {
            chars[size++] = s.charAt(i);
        }
        return this;
    }

    public MyStringBuilder1 append(int i) {
        String str = String.valueOf(i);
        ensureCapacity();
        for (int j = 0; j < str.length(); j++) {
            chars[size++] = str.charAt(j);
        }
        return this;
    }

    private void ensureCapacity() {
        if (size >= chars.length) {
            char[] newChars = new char[chars.length * 2];
            System.arraycopy(chars, 0, newChars, 0, chars.length);
            chars = newChars;
        }
    }

    public int length() {
        return size;
    }

    public char charAt(int index) {
        if (index < 0 || index >= size) {
            throw new StringIndexOutOfBoundsException("Index out of range");
        }
        return chars[index];
    }

    public MyStringBuilder1 toLowerCase() {
        for (int i = 0; i < size; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 'a' - 'A');
            }
        }
        return this;
    }

    public MyStringBuilder1 substring(int begin, int end) {
        if (begin < 0 || end > size || begin > end) {
            throw new StringIndexOutOfBoundsException("Index out of range");
        }
        String str = new String(chars, begin, end - begin);
        return new MyStringBuilder1(str);
    }

    @Override
    public String toString() {
        return new String(chars, 0, size);
    }

    public static void main(String[] args) {
        MyStringBuilder1 sb = new MyStringBuilder1("Hello");
        System.out.println("length(): " + sb.length());
        System.out.println("charAt(0): " + sb.charAt(0));
        System.out.println("toLowerCase(): " + sb.toLowerCase());
        System.out.println("substring(1, 4): " + sb.substring(1, 4));
        sb.append(new MyStringBuilder1(" World"));
        System.out.println("append(): " + sb);
        sb.append(123);
        System.out.println("append(int): " + sb);
    }
}
