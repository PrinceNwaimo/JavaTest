package leetCodeProblems;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return createTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private int searchDivIndex(int[] inorder, int lowInorder, int highInorder, int val) {
        for (int i = lowInorder; i <= highInorder; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    private TreeNode createTree(int[] inorder, int lowInorder, int highInorder,
                                int[] postorder, int lowPostorder, int highPostorder) {
        if (lowInorder > highInorder || lowPostorder > highPostorder) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[highPostorder]);
        int divIndex = searchDivIndex(inorder, lowInorder, highInorder, root.value);

        int sizeLeftSubtree = divIndex - lowInorder;
        int sizeRightSubtree = highInorder - divIndex;

        root.left = createTree(inorder, lowInorder, divIndex - 1,
                postorder, lowPostorder, lowPostorder + sizeLeftSubtree - 1);
        root.right = createTree(inorder, divIndex + 1, highInorder,
                postorder, lowPostorder + sizeLeftSubtree, highPostorder - 1);

        return root;
    }

    // Helper to print tree in inorder to verify
    private void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.value + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal sol =
                new ConstructBinaryTreeFromInorderAndPostorderTraversal();

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = sol.buildTree(inorder, postorder);

        System.out.print("Inorder of constructed tree: ");
        sol.printInorder(root); // Should print: 9 3 15 20 7
    }
}
