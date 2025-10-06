package liangHashing;

public class StringHashCode {
    public static int hashCodeForString(String s) {
        int hash = 0;
        int b = 31;
        int prime = (int) 1e9 + 7; // a large prime number
        for (int i = 0; i < s.length(); i++) {
            hash = (int) ((hash * (long) b + s.charAt(i)) % prime);
        }
        return hash;
    }

    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(hashCodeForString(s));
    }
}
