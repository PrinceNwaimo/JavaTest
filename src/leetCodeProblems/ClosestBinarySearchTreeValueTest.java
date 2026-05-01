package leetCodeProblems;

public class ClosestBinarySearchTreeValueTest {
    public static void main(String[] args) {
        // BST:     4
        //         / \
        //        2   5
        //       / \
        //      1   3
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        ClosestBinarySearchTreeValue sol = new ClosestBinarySearchTreeValue();

        System.out.println(sol.closestValue(root, 3.714286)); // 4
        System.out.println(new ClosestBinarySearchTreeValue().closestValue(root, 2.1)); // 2
        System.out.println(new ClosestBinarySearchTreeValue().closestValue(root, 3.9)); // 4
    }
}
