package leetCodeProblems;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) return true;

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            // skip non-alphanumeric from left
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            // skip non-alphanumeric from right
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
