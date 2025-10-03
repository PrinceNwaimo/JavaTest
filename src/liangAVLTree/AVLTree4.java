package liangAVLTree;

public class AVLTree4 <E extends  Comparable <E>> {
        private AVLTreeNode<E> root;

        public void insert(E e) {
            root = insert(root, e, null);
        }

        private AVLTreeNode<E> insert(AVLTreeNode<E> node, E e, AVLTreeNode<E> parent) {
            if (node == null) return new AVLTreeNode<>(e, parent);

            if (e.compareTo(node.element) < 0) {
                node.left = insert(node.left, e, node);
            } else if (e.compareTo(node.element) > 0) {
                node.right = insert(node.right, e, node);
            } else {
                return node; // duplicate not allowed
            }

            update(node);
            return balance(node);
        }

        // Update height and size
        private void update(AVLTreeNode<E> node) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
            node.size = 1 + size(node.left) + size(node.right);
        }

        private int height(AVLTreeNode<E> node) {
            return node == null ? 0 : node.height;
        }

        private int size(AVLTreeNode<E> node) {
            return node == null ? 0 : node.size;
        }

        private int getBalance(AVLTreeNode<E> node) {
            return node == null ? 0 : height(node.left) - height(node.right);
        }

        private AVLTreeNode<E> balance(AVLTreeNode<E> node) {
            int balance = getBalance(node);

            if (balance > 1) {
                if (getBalance(node.left) < 0) {
                    node.left = rotateLeft(node.left);
                }
                return rotateRight(node);
            }
            if (balance < -1) {
                if (getBalance(node.right) > 0) {
                    node.right = rotateRight(node.right);
                }
                return rotateLeft(node);
            }
            return node;
        }

        private AVLTreeNode<E> rotateRight(AVLTreeNode<E> y) {
            AVLTreeNode<E> x = y.left;
            AVLTreeNode<E> T2 = x.right;

            x.right = y;
            y.left = T2;

            if (T2 != null) T2.parent = y;
            x.parent = y.parent;
            y.parent = x;

            update(y);
            update(x);
            return x;
        }

        private AVLTreeNode<E> rotateLeft(AVLTreeNode<E> x) {
            AVLTreeNode<E> y = x.right;
            AVLTreeNode<E> T2 = y.left;

            y.left = x;
            x.right = T2;

            if (T2 != null) T2.parent = x;
            y.parent = x.parent;
            x.parent = y;

            update(x);
            update(y);
            return y;
        }

        // ✅ Find kth smallest in O(log n)
        public E find(int k) {
            if (k < 1 || k > size(root)) return null;
            return find(root, k);
        }

        private E find(AVLTreeNode<E> node, int k) {
            int leftSize = size(node.left);

            if (k == leftSize + 1) {
                return node.element;
            } else if (k <= leftSize) {
                return find(node.left, k);
            } else {
                return find(node.right, k - leftSize - 1);
            }
        }
    }


