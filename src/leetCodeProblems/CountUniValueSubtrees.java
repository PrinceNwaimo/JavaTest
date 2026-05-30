package leetCodeProblems;

public class CountUniValueSubtrees {
    private int count = 0;

    public int countUniValSubtrees(TreeNode root) {
        isUniVal(root);
        return count;
    }

    // Returns true if subtree rooted at node is uniVal
    private boolean isUniVal(TreeNode root) {
        if (root == null) {
            return true;
        }

        // Leaf node is always uniVal
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }

        boolean left = isUniVal(root.left);
        boolean right = isUniVal(root.right);

        // Check if current node is uniVal
        if (left && right &&
                (root.left == null || root.left.value == root.value) &&
                (root.right == null || root.right.value == root.value)) {
            count++;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        /*
              5
             / \
            1   5
           / \   \
          5   5   5
        UniValue subtrees: 3 leaves + root.right + root = 5
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(5);

        CountUniValueSubtrees sol = new CountUniValueSubtrees();
        int result = sol.countUniValSubtrees(root);

        System.out.println("Count of uniVal subtrees: " + result); // Output: 5
    }
}
