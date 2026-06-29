package leetCodeProblems;

public class PaintFence {
    public int numWays(int n, int k) {
        // dp[0] is unused, dp[1] = ways for 1 fence, dp[2] = ways for 2 fences
        int[] dp = {0, k, k * k, 0};

        if (n <= 2) {
            return dp[n];
        }

        for (int i = 2; i < n; i++) {
            dp[3] = (k - 1) * (dp[1] + dp[2]);
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[3];
    }

    public static void main(String[] args) {
        PaintFence pf = new PaintFence();

        // Test cases
        System.out.println("n=1, k=3: " + pf.numWays(1, 3));  // 3
        System.out.println("n=2, k=3: " + pf.numWays(2, 3));  // 9
        System.out.println("n=3, k=3: " + pf.numWays(3, 3));  // 24
        System.out.println("n=4, k=3: " + pf.numWays(4, 3));  // 66
        System.out.println("n=5, k=3: " + pf.numWays(5, 3));  // 180
        System.out.println("n=0, k=3: " + pf.numWays(0, 3));  // 0
        System.out.println("n=3, k=0: " + pf.numWays(3, 0));  // 0
        System.out.println("n=2, k=1: " + pf.numWays(2, 1));  // 1

        // Additional test cases
        System.out.println("\nMore test cases:");
        System.out.println("n=3, k=2: " + pf.numWays(3, 2));  // 6
        System.out.println("n=4, k=2: " + pf.numWays(4, 2));  // 10
        System.out.println("n=5, k=2: " + pf.numWays(5, 2));  // 16
    }
}
