package leetCodeProblems;
import java.util.Stack;

public class BSTIterator {
    private final Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode nextNode = stack.pop();
        TreeNode currentNode = nextNode.right;
        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.left;
        }
        return nextNode.value;
    }
}
