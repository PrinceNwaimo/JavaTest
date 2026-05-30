package leetCodeProblems;
import java.util.Stack;
import java.util.Arrays;

public class VerifyPreorderSequenceInBST {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int val : preorder) {
            // If current value is smaller than last popped root, violates BST rule
            if (val < root) {
                return false;
            }

            // Pop all smaller elements. Last popped becomes new lower bound
            while (!stack.isEmpty() && val > stack.peek()) {
                root = stack.pop();
            }

            stack.push(val);
        }
        return true;
    }

    public static void main(String[] args) {
        VerifyPreorderSequenceInBST sol = new VerifyPreorderSequenceInBST();

        int[] preorder1 = {5, 2, 1, 3, 6};
        System.out.println(Arrays.toString(preorder1) + " -> " + sol.verifyPreorder(preorder1));
        // Output: true

        int[] preorder2 = {5, 2, 6, 1, 3};
        System.out.println(Arrays.toString(preorder2) + " -> " + sol.verifyPreorder(preorder2));
        // Output: false, because 1 comes after 6 but 1 < 5
    }
}
