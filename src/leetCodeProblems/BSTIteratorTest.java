package leetCodeProblems;

public class BSTIteratorTest {
    public static void main(String[] args) {
        // Example:    7
        //           /   \
        //          3     15
        //               /  \
        //              9    20

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator i = new BSTIterator(root);
        while (i.hasNext()) {
            System.out.print(i.next() + " "); // 3 7 9 15 20
        }
    }
}
