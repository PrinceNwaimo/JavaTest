package liangAVLTree;

import liangBinarySearchTree.BST;

import java.util.ArrayList;

/**
 * AVL tree implementation that extends the provided BST.
 */
public class AVLTree<E extends Comparable<? super E>> extends BST<E> {

    public AVLTree() {
        super();
    }

    public AVLTree(E[] objects) {
        super(objects);
    }

    /**
     * Create a new AVLTreeNode (covariant return type of BST.createNewNode)
     */
    @Override
    protected BST.TreeNode<E> createNewNode(E e) {
        return new AVLTreeNode<>(e);
    }

    /**
     * Insert an element and rebalance if necessary
     */
    @Override
    public boolean insert(E e) {
        boolean successful = super.insert(e);
        if (!successful) {
            return false; // already in the tree
        } else {
            balancePath(e); // rebalance from inserted node up to root
        }
        return true;
    }

    /**
     * Update the height of a node (null children height = -1, leaf height = 0)
     */
    private void updateHeight(AVLTreeNode<E> node) {
        AVLTreeNode<E> left  = (AVLTreeNode<E>) node.left;
        AVLTreeNode<E> right = (AVLTreeNode<E>) node.right;

        int leftHeight  = (left  == null) ? -1 : left.height;
        int rightHeight = (right == null) ? -1 : right.height;

        node.height = 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Return the balance factor of node = height(left) - height(right)
     * (positive -> left-heavy, negative -> right-heavy)
     */
    private int balanceFactor(AVLTreeNode<E> node) {
        int leftHeight = (node.left == null) ? -1 : ((AVLTreeNode<E>) node.left).height;
        int rightHeight = (node.right == null) ? -1 : ((AVLTreeNode<E>) node.right).height;
        return leftHeight - rightHeight;
    }

    /**
     * Balance nodes in the path from the element's position up to the root.
     * We get the path from BST.path(e) which returns nodes from root to location.
     */
    private void balancePath(E e) {
        ArrayList<BST.TreeNode<E>> path = path(e);
        // traverse from bottom up
        for (int i = path.size() - 1; i >= 0; i--) {
            AVLTreeNode<E> A = (AVLTreeNode<E>) path.get(i);
            updateHeight(A);

            AVLTreeNode<E> parentOfA = (i > 0) ? (AVLTreeNode<E>) path.get(i - 1) : null;
            int balance = balanceFactor(A);

            if (balance == 2) { // left heavy
                if (balanceFactor((AVLTreeNode<E>) A.left) >= 0) {
                    // LL
                    rotateRight(A, parentOfA);
                } else {
                    // LR: first rotate left on left child, then right on A
                    rotateLeft((AVLTreeNode<E>) A.left, A);
                    rotateRight(A, parentOfA);
                }
            } else if (balance == -2) { // right heavy
                if (balanceFactor((AVLTreeNode<E>) A.right) <= 0) {
                    // RR
                    rotateLeft(A, parentOfA);
                } else {
                    // RL: first rotate right on right child, then left on A
                    rotateRight((AVLTreeNode<E>) A.right, A);
                    rotateLeft(A, parentOfA);
                }
            }
            // After rotations heights of affected nodes are updated inside rotate methods
        }
    }

    /**
     * Right rotation (rotate subtree rooted at A to the right).
     * parentOfA is the parent of A (may be null if A is root).
     */
    private void rotateRight(BST.TreeNode<E> nodeA, BST.TreeNode<E> parentOfA) {
        // A must be an AVLTreeNode
        AVLTreeNode<E> A = (AVLTreeNode<E>) nodeA;
        BST.TreeNode<E> nodeB = A.left; // B
        AVLTreeNode<E> B = (AVLTreeNode<E>) nodeB;

        // Perform rotation
        if (A == root) {
            root = B;
        } else {
            if (parentOfA.left == A) {
                parentOfA.left = B;
            } else {
                parentOfA.right = B;
            }
        }

        // rotate
        A.left = B.right;
        B.right = A;

        // update heights
        updateHeight((AVLTreeNode<E>) A);
        updateHeight(B);
    }

    /**
     * Left rotation (rotate subtree rooted at A to the left).
     * parentOfA is the parent of A (may be null if A is root).
     */
    private void rotateLeft(BST.TreeNode<E> nodeA, BST.TreeNode<E> parentOfA) {
        AVLTreeNode<E> A = (AVLTreeNode<E>) nodeA;
        BST.TreeNode<E> nodeB = A.right; // B
        AVLTreeNode<E> B = (AVLTreeNode<E>) nodeB;

        if (A == root) {
            root = B;
        } else {
            if (parentOfA.left == A) {
                parentOfA.left = B;
            } else {
                parentOfA.right = B;
            }
        }

        // rotate
        A.right = B.left;
        B.left = A;

        // update heights
        updateHeight((AVLTreeNode<E>) A);
        updateHeight(B);
    }

    /**
     * Delete an element and rebalance the path.
     * We leverage BST.delete and then rebalance ancestors of the deleted position.
     */
    @Override
    public boolean delete(E element) {
        // We capture path to element first (ancestors where element would be found)
        ArrayList<BST.TreeNode<E>> oldPath = path(element);

        boolean deleted = super.delete(element);
        if (!deleted) return false;

        // After deletion, rebalance starting from the parent-most ancestor (bottom up).
        // If path is empty, nothing to do. Otherwise, call balancePath on the element
        // (path(element) returns where element would be; that path contains ancestors).
        balancePath(element);
        return true;
    }

    /**
     * AVLTreeNode extends BST.TreeNode and adds height
     */
    protected static class AVLTreeNode<E> extends TreeNode<E> {
        int height = 0;  // new field for balancing

        AVLTreeNode(E element) {
            super(element);
        }
    }
}
