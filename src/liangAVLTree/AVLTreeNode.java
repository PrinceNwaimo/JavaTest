package liangAVLTree;

public class AVLTreeNode <E>{
        E element;
        AVLTreeNode<E> left, right, parent;
        int height;
        int size; // number of nodes in the subtree rooted at this node

        AVLTreeNode(E e, AVLTreeNode<E> parent) {
            element = e;
            this.parent = parent;
            height = 1;
            size = 1;
        }
    }


