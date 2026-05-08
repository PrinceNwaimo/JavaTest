package leetCodeProblems;

public class LowestCommonAncestorOfBSTII {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestor(root.right, p, q);

        if (leftLca != null && rightLca != null) {
            return root;
        }

        if (leftLca == null) {
            return rightLca;
        } else {
            return leftLca;
        }
    }

    public static void main(String[] args) {
        // Build tree:      3
        //                 / \
        //                5   1
        //               / \ / \
        //              6 2 0 8
        //                / \
        //               7   4
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right = new TreeNode(4);

        TreeNode p = root.left;        // 5
        TreeNode q = root.left.right; // 4

        LowestCommonAncestorOfBSTII sol = new LowestCommonAncestorOfBSTII();
        TreeNode lca = sol.lowestCommonAncestor(root, p, q);

        System.out.println("LCA of " + p.value + " and " + q.value + " is: " + lca.value); // 5
    }
}
