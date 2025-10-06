package liangHashing;

import javafx.application.Application;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LinearProbingAnimation extends Application {
    private static final int INITIAL_CAPACITY = 10;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    private int[] hashTable;
    private int size;
    private int capacity;
    private TextField inputField;
    private Label statusLabel;
    private Rectangle[] rectangles;
    private Text[] texts;

    @Override
    public void start(Stage primaryStage) {
        capacity = INITIAL_CAPACITY;
        hashTable = new int[capacity];
        size = 0;

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        VBox controlBox = new VBox(10);
        controlBox.setAlignment(Pos.CENTER);

        inputField = new TextField();
        inputField.setPrefWidth(100);
        Button insertButton = new Button("Insert");
        insertButton.setOnAction(e -> insert());
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e -> reset());

        statusLabel = new Label();

        controlBox.getChildren().addAll(new Label("Enter a number:"), inputField, insertButton, resetButton, statusLabel);

        HBox hashTableBox = new HBox(10);
        hashTableBox.setAlignment(Pos.CENTER);
        rectangles = new Rectangle[capacity];
        texts = new Text[capacity];

        for (int i = 0; i < capacity; i++) {
            Rectangle rectangle = new Rectangle(50, 50);
            rectangle.setFill(Color.WHITE);
            rectangle.setStroke(Color.BLACK);
            Text text = new Text(String.valueOf(hashTable[i]));
            texts[i] = text;
            hashTableBox.getChildren().addAll(rectangle, text);
            rectangles[i] = rectangle;
        }

        root.setTop(controlBox);
        root.setCenter(hashTableBox);

        Scene scene = new Scene(root, 600, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void insert() {
        try {
            int number = Integer.parseInt(inputField.getText());
            if (size >= capacity * LOAD_FACTOR_THRESHOLD) {
                resize();
            }
            int index = hash(number);
            while (hashTable[index] != 0) {
                index = (index + 1) % capacity;
            }
            hashTable[index] = number;
            size++;
            updateUI(index);
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid input");
        }
    }

    private void resize() {
        int newCapacity = capacity * 2;
        int[] newHashTable = new int[newCapacity];
        for (int i = 0; i < capacity; i++) {
            if (hashTable[i] != 0) {
                int index = hash(hashTable[i]) % newCapacity;
                while (newHashTable[index] != 0) {
                    index = (index + 1) % newCapacity;
                }
                newHashTable[index] = hashTable[i];
            }
        }
        capacity = newCapacity;
        hashTable = newHashTable;
        updateUI(-1);
    }

    private int hash(int number) {
        return Math.abs(number) % capacity;
    }

    private void updateUI(int index) {
        for (int i = 0; i < capacity; i++) {
            if (i == index) {
                rectangles[i].setFill(Color.RED);
            } else {
                rectangles[i].setFill(Color.WHITE);
            }
            texts[i].setText(String.valueOf(hashTable[i]));
        }
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), e -> {
            for (int i = 0; i < capacity; i++) {
                rectangles[i].setFill(Color.WHITE);
            }
        }));
        timeline.play();
    }

    private void reset() {
        hashTable = new int[capacity];
        size = 0;
        updateUI(-1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
