import static joyceTwoDimensionalArrays.DoesItHaveLegs.root;

public class TreeNode2 {
    int data;
    int count; // Track occurrences
    TreeNode2 left;
    TreeNode2 right;

    public TreeNode2(int data) {
        this.data = data;
        this.count = 1; // Initialize count
        this.left = null;
        this.right = null;
    }
}


//Insertion Method Adaptation

public void insert(int data, TreeNode2 root) {
    root = insertRecursive(root, data);
}

private TreeNode2 insertRecursive(TreeNode2 root, int data) {
    if (root == null) {
        return new TreeNode2(data);
    }

    if (data < root.data) {
        root.left = insertRecursive(root.left, data);
    } else if (data > root.data) {
        root.right = insertRecursive(root.right, data);
    } else {
        root.count++; // Increment count for duplicate
    }
    return root;
}


//Traversal Considerations
//- Inorder Traversal: Reflects sorted order; duplicates appear based on count handling.

public void inorderTraversal(TreeNode2 root) {
    inorderRecursive(root);
}

private void inorderRecursive(TreeNode2 root) {
    if (root != null) {
        inorderRecursive(root.left);
        for (int i = 0; i < root.count; i++) {
            System.out.print(root.data + " ");
        }
        inorderRecursive(root.right);
    }
}

public void main() {
}
