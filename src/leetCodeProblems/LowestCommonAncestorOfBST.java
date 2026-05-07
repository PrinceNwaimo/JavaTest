package leetCodeProblems;
import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfBST {
    private final List<Integer> inorderList = new ArrayList<>();
    private final List<Integer> postorderList = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        inorderTraversal(root);
        postorderTraversal(root);

        int indexNode1 = inorderList.indexOf(p.value);
        int indexNode2 = inorderList.indexOf(q.value);

        List<Integer> betweenElements;
        if (indexNode1 < indexNode2) {
            betweenElements = inorderList.subList(indexNode1, indexNode2 + 1);
        } else {
            betweenElements = inorderList.subList(indexNode2, indexNode1 + 1);
        }

        int lcaValue = findElementMaxIndex(betweenElements);

        // Find the TreeNode with that value
        return findNodeByValue(root, lcaValue);
    }

    private int findElementMaxIndex(List<Integer> betweenElements) {
        int maxIndex = -1;
        int element = -1;
        for (int val : betweenElements) {
            int elementIndex = postorderList.indexOf(val);
            if (elementIndex > maxIndex) {
                maxIndex = elementIndex;
                element = val;
            }
        }
        return element; // fixed: return after loop, not inside
    }

    private TreeNode findNodeByValue(TreeNode root, int value) {
        if (root == null) return null;
        if (root.value == value) return root;
        TreeNode left = findNodeByValue(root.left, value);
        return left != null ? left : findNodeByValue(root.right, value);
    }

    private void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            inorderList.add(node.value);
            inorderTraversal(node.right);
        }
    }

    private void postorderTraversal(TreeNode node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            postorderList.add(node.value);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left;  // 2
        TreeNode q = root.left.right; // 4

        LowestCommonAncestorOfBST lca = new LowestCommonAncestorOfBST();
        TreeNode result = lca.lowestCommonAncestor(root, p, q);

        System.out.println("LCA of " + p.value + " and " + q.value + " is: " + result.value); // 2
    }
}
