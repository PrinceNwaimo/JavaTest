package leetCodeProblems;

public class Serialize {
    public static void main(String[] args) {
        // Build test tree: 1 -> 2,3 and 2 -> null,4
        // 1
        // / \
        // 2 3
        // \
        // 4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        Codec ser = new Codec();
        Codec deser = new Codec();

        String serialized = ser.serialize(root);
        System.out.println("Serialized: " + serialized);
        // Output: 1,2,null,4,null,null,3,null,null

        TreeNode ans = deser.deserialize(serialized);
        System.out.println("Root after deserialize: " + ans.value); // 1
        System.out.println("Left child: " + ans.left.value); // 2
        System.out.println("Right child: " + ans.right.value); // 3
    }
}
