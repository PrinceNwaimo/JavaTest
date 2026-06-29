package leetCodeProblems;

public class SelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        if (x == null || x.length <= 3) {
            return false;
        }

        for (int i = 3; i < x.length; i++) {
            // Case 1: Fourth line crosses the first line
            if (x[i - 3] >= x[i - 1] && x[i - 2] <= x[i]) {
                return true;
            }

            // Case 2: Fifth line meets the first line
            if (i >= 4 && x[i - 4] + x[i] >= x[i - 2] && x[i - 3] == x[i - 1]) {
                return true;
            }

            // Case 3: Sixth line crosses the first line
            if (i >= 5 &&
                    x[i - 5] <= x[i - 3] &&
                    x[i - 4] <= x[i - 2] &&
                    x[i - 1] <= x[i - 3] &&
                    x[i - 1] >= x[i - 3] - x[i - 5] &&
                    x[i] >= x[i - 2] - x[i - 4] &&
                    x[i] <= x[i - 2]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SelfCrossing sc = new SelfCrossing();

        // Test cases
        int[][] testCases = {
                {2, 1, 1, 2},           // Expected: true (self-crossing)
                {1, 2, 3, 4},           // Expected: false
                {1, 1, 1, 1},           // Expected: true
                {1, 2, 2, 1, 1},        // Expected: true
                {3, 3, 3, 2, 1, 1},     // Expected: true
                {1, 1, 2, 1, 1}         // Expected: true
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] test = testCases[i];
            System.out.println("Test " + (i + 1) + ": " + java.util.Arrays.toString(test));
            System.out.println("Result: " + sc.isSelfCrossing(test));
            System.out.println();
        }

        // Edge cases
        System.out.println("Edge Cases:");
        System.out.println("null: " + sc.isSelfCrossing(null));
        System.out.println("[]: " + sc.isSelfCrossing(new int[]{}));
        System.out.println("[1, 2, 3]: " + sc.isSelfCrossing(new int[]{1, 2, 3}));
    }
}
