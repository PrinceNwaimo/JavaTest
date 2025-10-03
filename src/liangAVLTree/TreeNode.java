package liangAVLTree;

public class TreeNode<E> {
    E element;
    TreeNode<E> left;
    TreeNode<E> right;
    TreeNode<E> parent; // parent reference
    int height; // for AVL balancing

    public TreeNode(E e, TreeNode<E> parent) {
        element = e;
        this.parent = parent;
        height = 1; // new node starts with height 1
    }
}
