package leetCodeProblems;

public class ReverseString {
    public String reverseString(String s) {
        char[] currentStr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char temp = currentStr[i];
            currentStr[i] = currentStr[j];
            currentStr[j] = temp;
            i++;
            j--;
        }
        return new String(currentStr);
    }

    public static void main(String[] args) {
        ReverseString r = new ReverseString();

        System.out.println(r.reverseString("hello"));
        System.out.println(r.reverseString("A man, a plan"));
        System.out.println(r.reverseString(""));
    }
}
