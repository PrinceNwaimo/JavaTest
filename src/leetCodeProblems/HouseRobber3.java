package leetCodeProblems;

public class HouseRobber3 {
    public int rob(TreeNode root) {
        int[] result = robMax(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robMax(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] leftRes = robMax(root.left);
        int[] rightRes = robMax(root.right);

        int[] result = new int[2];

        // result[0] = rob current node: can't rob children
        result[0] = root.value + leftRes[1] + rightRes[1];

        // result[1] = don't rob current node: take max of each child
        result[1] = Math.max(leftRes[0], leftRes[1]) + Math.max(rightRes[0], rightRes[1]);

        return result;
    }

    public static void main(String[] args) {
        /*
              3
             / \
            2 3
             \ \
              3 1
        Max: 3 + 3 + 1 = 7
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(1);

        HouseRobber3 sol = new HouseRobber3();
        int maxMoney = sol.rob(root);

        System.out.println("Max money you can rob: " + maxMoney); // Output: 7
    }
}
