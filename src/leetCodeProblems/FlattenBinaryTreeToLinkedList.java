package leetCodeProblems;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                current.right = current.left;
                current.left = null;
            } else if (!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                current.right = temp;
            }
            current = current.right;
        }
    }

    public static void main(String[] args) {
        // Example: build tree [1,2,5,3,4,null,6]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);

        FlattenBinaryTreeToLinkedList sol = new FlattenBinaryTreeToLinkedList();
        sol.flatten(root);

        // Print flattened list
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.value + " -> ");
            curr = curr.right;
        }
        System.out.println("null");
    }
}
