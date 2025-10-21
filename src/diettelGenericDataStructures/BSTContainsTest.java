package diettelGenericDataStructures;

public class BSTContainsTest {
    public static void main(String[] args) {
        BinarySearchTree2 bst = new BinarySearchTree2();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder Traversal:");
        bst.inorderTraversal();

        int searchKey1 = 40;
        Integer result1 = bst.contains(searchKey1);
        System.out.println("Searching for " + searchKey1 + ": " + (result1 != null ? "Found " + result1 : "Not found"));

        int searchKey2 = 90;
        Integer result2 = bst.contains(searchKey2);
        System.out.println("Searching for " + searchKey2 + ": " + (result2 != null ? "Found " + result2 : "Not found"));
    }
}
