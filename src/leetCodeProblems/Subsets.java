package leetCodeProblems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        // Sort the array first
        Arrays.sort(S);

        List<List<Integer>> res = new ArrayList<>();

        // Inner recursive function - implemented as a helper method
        dfs(S, 0, 0, new ArrayList<>(), res);

        return res;
    }

    private void dfs(int[] S, int depth, int start, List<Integer> valuelist,
                     List<List<Integer>> res) {
        // Add a copy of the current valuelist to results
        res.add(new ArrayList<>(valuelist));

        if (depth == S.length) {
            return;
        }

        for (int i = start; i < S.length; i++) {
            valuelist.add(S[i]);
            dfs(S, depth + 1, i + 1, valuelist, res);
            valuelist.remove(valuelist.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();

        // Test cases
        int[] test1 = {1, 2, 3};
        System.out.println("Subsets of " + Arrays.toString(test1) + ":");
        System.out.println(subsets.subsets(test1));

        int[] test2 = {3, 1, 2};
        System.out.println("\nSubsets of " + Arrays.toString(test2) + ":");
        System.out.println(subsets.subsets(test2));

        int[] test3 = {1, 2, 2, 3};
        System.out.println("\nSubsets of " + Arrays.toString(test3) + ":");
        System.out.println(subsets.subsets(test3));
    }
}
