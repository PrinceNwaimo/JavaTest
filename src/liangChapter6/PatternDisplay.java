package liangChapter6;

public class PatternDisplay {
    public static void main(String[] args) {
        displayPattern(7);
    }

    public static void displayPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}
