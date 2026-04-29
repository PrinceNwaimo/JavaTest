package leetCodeProblems;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        // Fixed: return true if values equal AND subtrees are mirrors
        if (root1.value == root2.value) {
            return isMirror(root1.left, root2.right) &&
                    isMirror(root1.right, root2.left);
        } else {
            return false;
        }
    }
}
