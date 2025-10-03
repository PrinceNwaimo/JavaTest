package liangAVLTree;

public class TestAVLTree2 {
        public static void main(String[] args) {
            AVLTree<Integer> tree = new AVLTree<>();

            // Insert numbers 1–100
            for (int i = 1; i <= 100; i++) {
                tree.insert(i);
            }

            // Print all leaf paths
            System.out.println("Paths from root to leaf nodes:");
            tree.printLeafPaths();
        }
    }


