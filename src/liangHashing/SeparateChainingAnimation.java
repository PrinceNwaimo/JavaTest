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

public class SeparateChainingAnimation extends Application {
    private static final int INITIAL_CAPACITY = 10;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    private Node[] hashTable;
    private int size;
    private int capacity;
    private TextField keyField;
    private TextField valueField;
    private Label statusLabel;
    private Rectangle[] rectangles;
    private Text[] texts, lines;

    @Override
    public void start(Stage primaryStage) {
        capacity = INITIAL_CAPACITY;
        hashTable = new Node[capacity];
        size = 0;

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        VBox controlBox = new VBox(10);
        controlBox.setAlignment(Pos.CENTER);

        keyField = new TextField();
        keyField.setPrefWidth(100);
        valueField = new TextField();
        valueField.setPrefWidth(100);
        Button insertButton = new Button("Insert");
        insertButton.setOnAction(e -> insert());
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e -> reset());

        statusLabel = new Label();

        controlBox.getChildren().addAll(new Label("Enter key and value:"), keyField, valueField, insertButton, resetButton, statusLabel);

        HBox hashTableBox = new HBox(10);
        hashTableBox.setAlignment(Pos.CENTER);
        rectangles = new Rectangle[capacity];
        texts = new Text[capacity];
        lines = new Text[capacity];

        for (int i = 0; i < capacity; i++) {
            Rectangle rectangle = new Rectangle(50, 200);
            rectangle.setFill(Color.WHITE);
            rectangle.setStroke(Color.BLACK);
            Text text = new Text("Bucket " + i);
            Text line = new Text();
            texts[i] = text;
            lines[i] = line;
            hashTableBox.getChildren().addAll(rectangle, text, line);
            rectangles[i] = rectangle;
        }

        root.setTop(controlBox);
        root.setCenter(hashTableBox);

        Scene scene = new Scene(root, 800, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void insert() {
        try {
            int key = Integer.parseInt(keyField.getText());
            int value = Integer.parseInt(valueField.getText());
            if (size >= capacity * LOAD_FACTOR_THRESHOLD) {
                resize();
            }
            int index = hash(key);
            Node node = hashTable[index];
            while (node != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                node = node.next;
            }
            node = new Node(key, value);
            node.next = hashTable[index];
            hashTable[index] = node;
            size++;
            updateUI(index);
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid input");
        }
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Node[] newHashTable = new Node[newCapacity];
        for (int i = 0; i < capacity; i++) {
            Node node = hashTable[i];
            while (node != null) {
                Node next = node.next;
                int index = hash(node.key) % newCapacity;
                node.next = newHashTable[index];
                newHashTable[index] = node;
                node = next;
            }
        }
        capacity = newCapacity;
        hashTable = newHashTable;
        updateUI(-1);
    }

    private int hash(int key) {
        return Math.abs(key) % capacity;
    }

    private void updateUI(int index) {
        for (int i = 0; i < capacity; i++) {
            if (i == index) {
                rectangles[i].setFill(Color.RED);
            } else {
                rectangles[i].setFill(Color.WHITE);
            }
            StringBuilder sb = new StringBuilder();
            Node node = hashTable[i];
            while (node != null) {
                sb.append(node.key).append(":").append(node.value).append("\n");
                node = node.next;
            }
            lines[i].setText(sb.toString());
        }
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), e -> {
            for (int i = 0; i < capacity; i++) {
                rectangles[i].setFill(Color.WHITE);
            }
        }));
        timeline.play();
    }

    private void reset() {
        hashTable = new Node[capacity];
        size = 0;
        updateUI(-1);
    }

    private static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
