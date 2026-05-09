package leetCodeProblems;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] solutions = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            solutions[i] = -1;
        }
        return numTreesHelper(n, solutions);
    }

    private int numTreesHelper(int n, int[] solutions) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        int possibilities = 0;

        for (int i = 0; i < n; i++) {
            if (solutions[i] == -1) {
                solutions[i] = numTreesHelper(i, solutions);
            }
            if (solutions[n - 1 - i] == -1) {
                solutions[n - 1 - i] = numTreesHelper(n - 1 - i, solutions);
            }
            possibilities += solutions[i] * solutions[n - 1 - i];
        }

        return possibilities;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees sol = new UniqueBinarySearchTrees();

        int n = 3;
        int result = sol.numTrees(n);
        System.out.println("Number of unique BSTs for n = " + n + ": " + result); // 5

        n = 5;
        System.out.println("Number of unique BSTs for n = " + n + ": " + sol.numTrees(n)); // 42
    }
}
