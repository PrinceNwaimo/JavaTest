package liangSortingAlgorithms;

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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HeapVisualizer  extends Application {
    private ArrayList<Integer> heap = new ArrayList<>();
    private Pane pane = new Pane();

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);

        TextField textField = new TextField();
        Button insertButton = new Button("Insert");
        insertButton.setOnAction(e -> {
            try {
                int value = Integer.parseInt(textField.getText());
                heap.add(value);
                heapifyUp(heap.size() - 1);
                drawHeap();
                textField.clear();
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input");
            }
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            if (!heap.isEmpty()) {
                heap.set(0, heap.get(heap.size() - 1));
                heap.remove(heap.size() - 1);
                heapifyDown(0);
                drawHeap();
            }
        });

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Enter a value:"), textField, insertButton, deleteButton);
        hBox.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBox);
        BorderPane.setMargin(hBox, new Insets(10));

        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setTitle("Heap Visualizer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void heapifyUp(int index) {
        if (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index) > heap.get(parentIndex)) {
                int temp = heap.get(index);
                heap.set(index, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                heapifyUp(parentIndex);
            }
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largestIndex = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex) > heap.get(largestIndex)) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(largestIndex)) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) {
            int temp = heap.get(index);
            heap.set(index, heap.get(largestIndex));
            heap.set(largestIndex, temp);
            heapifyDown(largestIndex);
        }
    }

    private void drawHeap() {
        pane.getChildren().clear();
        drawHeap(0, 400, 50);
    }

    private void drawHeap(int index, double x, double y) {
        if (index >= heap.size()) {
            return;
        }

        Circle circle = new Circle(x, y, 20);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);

        Text text = new Text(x - 5, y + 5, String.valueOf(heap.get(index)));
        pane.getChildren().add(text);

        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        if (leftChildIndex < heap.size()) {
            Line line = new Line(x, y + 20, x - 150, y + 70);
            pane.getChildren().add(line);
            drawHeap(leftChildIndex, x - 150, y + 100);
        }

        if (rightChildIndex < heap.size()) {
            Line line = new Line(x, y + 20, x + 150, y + 70);
            pane.getChildren().add(line);
            drawHeap(rightChildIndex, x + 150, y + 100);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
