package leetCodeProblems;

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        // Find node p and track potential successor
        while (root != null && root.value != p.value) {
            if (root.value > p.value) {
                successor = root;  // current root could be successor
                root = root.left;
            } else {
                root = root.right;
            }
        }

        // If p not found
        if (root == null) {
            return null;
        }

        // If p has right subtree, successor is leftmost node in right subtree
        if (root.right != null) {
            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        return successor;
    }

    public static void main(String[] args) {
        /*
              5
             / \
            3   6
           / \
          2   4
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        TreeNode p = root.left.right; // node 4
        InorderSuccessorInBST sol = new InorderSuccessorInBST();
        TreeNode successor = sol.inorderSuccessor(root, p);

        if (successor != null) {
            System.out.println("Inorder successor of " + p.value + " is " + successor.value); // Output: 5
        } else {
            System.out.println("No inorder successor");
        }
    }
}
