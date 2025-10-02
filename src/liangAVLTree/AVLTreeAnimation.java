package liangAVLTree;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AVLTreeAnimation extends Application {
    @Override
    public void start(Stage primaryStage) {
        AVLTree<Integer> tree = new AVLTree<>(); // Create an AVL tree

        BorderPane pane = new BorderPane();

        // Create a view for the AVL tree
        AVLTreeView view = new AVLTreeView(tree);
        pane.setCenter(view);

        // Controls at the bottom
        TextField tfKey = new TextField();
        tfKey.setPrefColumnCount(3);
        tfKey.setAlignment(Pos.BASELINE_RIGHT);
        Button btInsert = new Button("Insert");
        Button btDelete = new Button("Delete");

        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("Enter a key:"), tfKey, btInsert, btDelete);
        hBox.setAlignment(Pos.CENTER);
        pane.setBottom(hBox);

        // Insert action
        btInsert.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            if (tree.search(key)) {
                view.displayTree();
                view.setStatus(key + " is already in the tree");
            } else {
                tree.insert(key);
                view.displayTree();
                view.setStatus(key + " is inserted in the tree");
            }
        });

        // Delete action
        btDelete.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            if (!tree.search(key)) {
                view.displayTree();
                view.setStatus(key + " is not in the tree");
            } else {
                tree.delete(key);
                view.displayTree();
                view.setStatus(key + " is deleted from the tree");
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("AVL Tree Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

