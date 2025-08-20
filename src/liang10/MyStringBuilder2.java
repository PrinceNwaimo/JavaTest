package liang10;

public class MyStringBuilder2 {
    private char[] chars;
    private int size;

    public MyStringBuilder2() {
        chars = new char[16];
        size = 0;
    }

    public MyStringBuilder2(char[] chars) {
        this.chars = new char[chars.length * 2];
        System.arraycopy(chars, 0, this.chars, 0, chars.length);
        size = chars.length;
    }

    public MyStringBuilder2(String s) {
        chars = new char[s.length() * 2];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        size = s.length();
    }

    public MyStringBuilder2 insert(int offset, MyStringBuilder2 s) {
        if (offset < 0 || offset > size) {
            throw new StringIndexOutOfBoundsException("Index out of range");
        }
        ensureCapacity(size + s.size);
        System.arraycopy(chars, offset, chars, offset + s.size, size - offset);
        System.arraycopy(s.chars, 0, chars, offset, s.size);
        size += s.size;
        return this;
    }

    public MyStringBuilder2 reverse() {
        int left = 0;
        int right = size - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return this;
    }

    public MyStringBuilder2 substring(int begin) {
        if (begin < 0 || begin > size) {
            throw new StringIndexOutOfBoundsException("Index out of range");
        }
        return new MyStringBuilder2(new String(chars, begin, size - begin));
    }

    public MyStringBuilder2 toUpperCase() {
        for (int i = 0; i < size; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 'a' + 'A');
            }
        }
        return this;
    }

    private void ensureCapacity(int capacity) {
        if (capacity > chars.length) {
            char[] newChars = new char[capacity * 2];
            System.arraycopy(chars, 0, newChars, 0, size);
            chars = newChars;
        }
    }

    @Override
    public String toString() {
        return new String(chars, 0, size);
    }

    public static void main(String[] args) {
        MyStringBuilder2 sb = new MyStringBuilder2("Hello");
        System.out.println("reverse(): " + sb.reverse());
        System.out.println("substring(1): " + sb.substring(1));
        System.out.println("toUpperCase(): " + sb.toUpperCase());
        MyStringBuilder2 sb2 = new MyStringBuilder2(" World");
        System.out.println("insert(): " + sb.insert(0, sb2));
    }
}
