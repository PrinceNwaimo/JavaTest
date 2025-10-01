package liangSortingAlgorithms;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Random;

public class QuickSortPartitionAnimation extends Application {
    private static final int ARRAY_SIZE = 20;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 200;
    private int[] array = new int[ARRAY_SIZE];
    private int low = 0;
    private int high = ARRAY_SIZE - 1;
    private int pivot = array[high];
    private boolean isFinished = false;

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        borderPane.setCenter(pane);

        generateRandomArray();
        drawArray(pane);

        Button stepButton = new Button("Step");
        stepButton.setOnAction(e -> step(pane));

        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e -> {
            generateRandomArray();
            low = 0;
            high = ARRAY_SIZE - 1;
            pivot = array[high];
            isFinished = false;
            drawArray(pane);
        });

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(stepButton, resetButton);
        hBox.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBox);
        BorderPane.setMargin(hBox, new Insets(10));

        Scene scene = new Scene(borderPane, WIDTH, HEIGHT + 50);
        primaryStage.setTitle("Quick Sort Partition Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateRandomArray() {
        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(999) + 1;
        }
    }

    private void drawArray(Pane pane) {
        pane.getChildren().clear();
        double width = WIDTH / ARRAY_SIZE;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            Rectangle rectangle = new Rectangle(i * width, HEIGHT - array[i] * HEIGHT / 1000, width, array[i] * HEIGHT / 1000);
            if (i == low) {
                rectangle.setFill(Color.RED);
            } else if (i == high) {
                rectangle.setFill(Color.BLUE);
            } else {
                rectangle.setFill(Color.GREEN);
            }
            pane.getChildren().add(rectangle);
            Text text = new Text(i * width, HEIGHT - 10, String.valueOf(array[i]));
            pane.getChildren().add(text);
        }
        if (isFinished) {
            Text text = new Text(WIDTH / 2 - 50, 20, "Partition Finished");
            pane.getChildren().add(text);
        }
    }

    private void step(Pane pane) {
        if (isFinished) {
            return;
        }
        if (low < high) {
            if (array[low] <= pivot) {
                low++;
            } else if (array[high] > pivot) {
                high--;
            } else {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
                low++;
                high--;
            }
            drawArray(pane);
        } else {
            isFinished = true;
            drawArray(pane);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
