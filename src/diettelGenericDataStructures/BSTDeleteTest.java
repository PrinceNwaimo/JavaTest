package diettelGenericDataStructures;

public class BSTDeleteTest {
    public static void main(String[] args) {
        BinarySearchTree2 bst = new BinarySearchTree2();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder Traversal before deletion:");
        bst.inorderTraversal();

        bst.deleteNode(20);
        System.out.println("Inorder Traversal after deleting 20:");
        bst.inorderTraversal();

        bst.deleteNode(30);
        System.out.println("Inorder Traversal after deleting 30:");
        bst.inorderTraversal();

        bst.deleteNode(50);
        System.out.println("Inorder Traversal after deleting 50:");
        bst.inorderTraversal();

        System.out.println("Preorder Traversal:");
        bst.preorderTraversal();

        System.out.println("Postorder Traversal:");
        bst.postorderTraversal();
    }
}
