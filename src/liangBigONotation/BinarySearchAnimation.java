package liangBigONotation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.application.Application;

public class BinarySearchAnimation extends Application {
    private int[] array = new int[20];
    private int key;
    private int low = 0;
    private int high = array.length - 1;
    private boolean found = false;
    private boolean finished = true;
    private Label statusLabel;
    private TextField keyField;
    private Button stepButton;
    private Button resetButton;
    private Pane pane;
    private Rectangle[] rectangles;

    @Override
    public void start(Stage primaryStage) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        statusLabel = new Label("Enter a key and click Step");
        keyField = new TextField();
        stepButton = new Button("Step");
        resetButton = new Button("Reset");
        pane = new Pane();
        rectangles = new Rectangle[array.length];
        for (int i = 0; i < array.length; i++) {
            Rectangle rectangle = new Rectangle(i * 30, 200 - array[i] * 10, 20, array[i] * 10);
            rectangle.setFill(Color.WHITE);
            rectangle.setStroke(Color.BLACK);
            pane.getChildren().add(rectangle);
            rectangles[i] = rectangle;
        }

        stepButton.setOnAction(e -> {
            if (finished) {
                try {
                    key = Integer.parseInt(keyField.getText());
                } catch (NumberFormatException ex) {
                    statusLabel.setText("Invalid key");
                    return;
                }
                finished = false;
                keyField.setEditable(false);
                step();
            }
        });

        resetButton.setOnAction(e -> {
            finished = true;
            keyField.setEditable(true);
            low = 0;
            high = array.length - 1;
            found = false;
            for (int i = 0; i < array.length; i++) {
                rectangles[i].setFill(Color.WHITE);
            }
            statusLabel.setText("Enter a key and click Step");
        });

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(stepButton, resetButton);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(statusLabel);
        borderPane.setCenter(pane);
        borderPane.setBottom(new HBox(10, keyField, hBox));
        borderPane.setPadding(new Insets(10));

        Scene scene = new Scene(borderPane, 600, 300);
        primaryStage.setTitle("Binary Search Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void step() {
        if (low <= high) {
            for (int i = 0; i < array.length; i++) {
                if (i >= low && i <= high) {
                    rectangles[i].setFill(Color.LIGHTGRAY);
                } else {
                    rectangles[i].setFill(Color.WHITE);
                }
            }
            int mid = (low + high) / 2;
            rectangles[mid].setFill(Color.BLACK);
            if (array[mid] == key) {
                statusLabel.setText("Key found at index " + mid);
                finished = true;
                found = true;
            } else if (array[mid] < key) {
                low = mid + 1;
                statusLabel.setText("Key is in the range [" + low + ", " + high + "]");
            } else {
                high = mid - 1;
                statusLabel.setText("Key is in the range [" + low + ", " + high + "]");
            }
        } else {
            if (!found) {
                statusLabel.setText("Key not found");
            }
            finished = true;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
