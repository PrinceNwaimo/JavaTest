package leetCodeProblems;

public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode pole = root;
        TreeNode parent = null;
        TreeNode parentRight = null;

        while (pole != null) {
            TreeNode left = pole.left;        // save next node to process

            pole.left = parentRight;          // original right becomes new left
            parentRight = pole.right;         // save original right for next iteration

            pole.right = parent;              // original parent becomes new right

            parent = pole;                    // move parent forward
            pole = left;                      // move pole to original left
        }

        return parent; // parent ends up as new root
    }

    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \
          4   5
        After upside down:
              4
             / \
            5   2
               / \
              3   1
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreeUpsideDown sol = new BinaryTreeUpsideDown();
        TreeNode newRoot = sol.upsideDownBinaryTree(root);

        // Print new root value to verify
        System.out.println("New root: " + newRoot.value); // Output: 4
    }
}
