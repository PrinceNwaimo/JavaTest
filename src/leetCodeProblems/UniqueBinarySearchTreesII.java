package leetCodeProblems;
import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTreesHelper(1, n);
    }

    private List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();

        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            // Generate all left and right subtrees
            List<TreeNode> leftTrees = generateTreesHelper(start, i - 1);
            List<TreeNode> rightTrees = generateTreesHelper(i + 1, end);

            // Combine left and right subtrees with the current node
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = left;
                    currentTree.right = right;
                    allTrees.add(currentTree);
                }
            }
        }

        return allTrees;
    }

    // Helper to print tree structure in pre-order for testing
    private void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.value + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII sol = new UniqueBinarySearchTreesII();
        int n = 3;
        List<TreeNode> trees = sol.generateTrees(n);

        System.out.println("Total unique BSTs for n=" + n + ": " + trees.size());
        System.out.println("Trees in pre-order:");

        for (int i = 0; i < trees.size(); i++) {
            System.out.print("Tree " + (i + 1) + ": ");
            sol.printTree(trees.get(i));
            System.out.println();
        }
    }
}
