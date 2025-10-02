package liangAVLTree;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;

public class AVLTreeAnimation2 extends Application {
    private AVLTree<Integer> tree = new AVLTree<>();
    private AVLTreeView view = new AVLTreeView(tree);

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setCenter(view);

        // Controls
        TextField tfKey = new TextField();
        tfKey.setPrefColumnCount(4);
        Button btInsert = new Button("Insert");
        Button btDelete = new Button("Delete");
        Button btSearch = new Button("Search");

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Enter a key: "), tfKey, btInsert, btDelete, btSearch);
        pane.setTop(hBox);

        // Actions
        btInsert.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            if (tree.search(key)) {
                view.displayTree();
                view.setStatus(key + " is already in the tree");
            } else {
                tree.insert(key);
                view.displayTree();
                view.setStatus(key + " inserted");
            }
        });

        btDelete.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            if (!tree.search(key)) {
                view.displayTree();
                view.setStatus(key + " is not in the tree");
            } else {
                tree.delete(key);
                view.displayTree();
                view.setStatus(key + " deleted");
            }
        });

        btSearch.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            boolean found = tree.search(key);
            view.displayTree();
            view.setStatus(found ? key + " is in the tree" : key + " is not in the tree");
        });

        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("AVL Tree Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // ================= Tree View ==================
    class AVLTreeView extends Pane {
        private AVLTree<Integer> tree;
        private double radius = 20; // radius of node circle
        private double vGap = 50;   // vertical gap between levels
        private Label status = new Label();

        AVLTreeView(AVLTree<Integer> tree) {
            this.tree = tree;
            setStatus("Tree is empty");
        }

        public void setStatus(String msg) {
            status.setText(msg);
            getChildren().add(status);
            status.setLayoutX(10);
            status.setLayoutY(10);
        }

        public void displayTree() {
            this.getChildren().clear();
            if (tree.getRoot() != null) {
                displayTree((AVLTree.AVLTreeNode<Integer>) tree.getRoot(), getWidth() / 2, vGap, getWidth() / 4);
            }
        }

        private void displayTree(AVLTree.AVLTreeNode<Integer> root, double x, double y, double hGap) {
            if (root.left != null) {
                // Draw line left child
                getChildren().add(new Line(x, y, x - hGap, y + vGap));
                displayTree((AVLTree.AVLTreeNode<Integer>) root.left, x - hGap, y + vGap, hGap / 2);
            }

            if (root.right != null) {
                // Draw line right child
                getChildren().add(new Line(x, y, x + hGap, y + vGap));
                displayTree((AVLTree.AVLTreeNode<Integer>) root.right, x + hGap, y + vGap, hGap / 2);
            }

            // Draw node
            Circle circle = new Circle(x, y, radius);
            circle.setFill(Color.LIGHTBLUE);
            circle.setStroke(Color.BLACK);
            getChildren().add(circle);

            // Show value
            getChildren().add(new Text(x - 6, y + 4, root.element + ""));

            // Show balance factor
            int balance = balanceFactor(root);
            getChildren().add(new Text(x - 6, y - 25, "(" + balance + ")"));
        }

        private int balanceFactor(AVLTree.AVLTreeNode<Integer> node) {
            int leftHeight = (node.left == null) ? -1 : ((AVLTree.AVLTreeNode<Integer>) node.left).height;
            int rightHeight = (node.right == null) ? -1 : ((AVLTree.AVLTreeNode<Integer>) node.right).height;
            return rightHeight - leftHeight;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

