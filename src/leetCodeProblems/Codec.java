package leetCodeProblems;
import java.util.*;

public class Codec {
    private final List<String> serializedList;
    private int index;

    public Codec() {
        this.serializedList = new ArrayList<>();
        this.index = 0;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serializedList.clear();
        serializeHelper(root);
        return String.join(",", serializedList);
    }

    private void serializeHelper(TreeNode root) {
        if (root == null) {
            serializedList.add("null");
            return;
        }
        serializedList.add(String.valueOf(root.value));
        serializeHelper(root.left);
        serializeHelper(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        index = 0;
        return deserializeHelper(dataArr);
    }

    private TreeNode deserializeHelper(String[] data) {
        if (index >= data.length || data[index].equals("null")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[index]));
        index++;
        root.left = deserializeHelper(data);
        root.right = deserializeHelper(data);
        return root;
    }
}
