package liangAVLTree;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class AVLTreeView extends Pane {
    private AVLTree<Integer> tree;
    private double radius = 15; // Node circle radius
    private double vGap = 50;   // Vertical gap between levels

    private Text status = new Text(20, 20, "");

    public AVLTreeView(AVLTree<Integer> tree) {
        this.tree = tree;
        getChildren().add(status);
    }

    public void setStatus(String msg) {
        status.setText(msg);
    }

    public void displayTree() {
        this.getChildren().clear();
        getChildren().add(status);
        if (tree.getRoot() != null) {
            displayTree((AVLTree.AVLTreeNode<Integer>) tree.getRoot(), getWidth() / 2, vGap, getWidth() / 4);
        }
    }

    private void displayTree(AVLTree.AVLTreeNode<Integer> root, double x, double y, double hGap) {
        if (root.left != null) {
            // Draw a line to the left child
            getChildren().add(new Line(x - hGap, y + vGap, x, y));
            displayTree((AVLTree.AVLTreeNode<Integer>) root.left, x - hGap, y + vGap, hGap / 2);
        }

        if (root.right != null) {
            // Draw a line to the right child
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            displayTree((AVLTree.AVLTreeNode<Integer>) root.right, x + hGap, y + vGap, hGap / 2);
        }

        // Draw the node as a circle
        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().add(circle);

        // Node value
        getChildren().add(new Text(x - 4, y + 4, root.element + ""));

        // Balance factor next to node
        int balanceFactor = height((AVLTree.AVLTreeNode<Integer>) root.left) -
                height((AVLTree.AVLTreeNode<Integer>) root.right);
        getChildren().add(new Text(x + 20, y, "BF=" + balanceFactor));
    }

    private int height(AVLTree.AVLTreeNode<Integer> node) {
        return (node == null) ? -1 : node.height;
    }
}

