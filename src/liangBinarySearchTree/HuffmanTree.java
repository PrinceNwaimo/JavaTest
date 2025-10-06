package liangBinarySearchTree;
import java.util.PriorityQueue;

public class HuffmanTree {
    TreeNode root;

    public HuffmanTree(int[] counts) {
        PriorityQueue<TreeNode> queue = new PriorityQueue<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                queue.offer(new TreeNode((char)i, counts[i]));
            }
        }

        while (queue.size() > 1) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            TreeNode merged = new TreeNode('\0', t1.weight + t2.weight);
            merged.left = t1;
            merged.right = t2;
            queue.offer(merged);
        }

        root = queue.poll();
    }

    public TreeNode getRoot() {
        return root;
    }

    public String[] getCodeTable() {
        String[] codes = new String[256];
        assignCodes(root, "", codes);
        return codes;
    }

    private void assignCodes(TreeNode node, String code, String[] codes) {
        if (node.left == null && node.right == null) {
            codes[node.element] = code;
            return;
        }
        assignCodes(node.left, code + '0', codes);
        assignCodes(node.right, code + '1', codes);
    }

    static class TreeNode implements Comparable<TreeNode> {
        char element;
        int weight;
        TreeNode left;
        TreeNode right;

        public TreeNode(char element, int weight) {
            this.element = element;
            this.weight = weight;
        }

        @Override
        public int compareTo(TreeNode o) {
            return this.weight - o.weight;
        }
    }
}

