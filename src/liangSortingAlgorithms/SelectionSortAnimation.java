package liangSortingAlgorithms;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

import java.util.Random;

public class SelectionSortAnimation extends Application {
    private static final int ARRAY_SIZE = 20;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private int[] array = new int[ARRAY_SIZE];
    private Rectangle[] rectangles = new Rectangle[ARRAY_SIZE];
    private int currentIndex = 0;
    private int minIndex = 0;
    private boolean isSorted = false;
    private Timeline timeline;

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        borderPane.setCenter(pane);

        generateRandomArray();
        drawArray(pane);

        Button stepButton = new Button("Step");
        stepButton.setOnAction(e -> step());

        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e -> {
            generateRandomArray();
            drawArray(pane);
            currentIndex = 0;
            minIndex = 0;
            isSorted = false;
        });

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(stepButton, resetButton);
        hBox.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBox);
        BorderPane.setMargin(hBox, new Insets(10));

        Scene scene = new Scene(borderPane, WIDTH, HEIGHT + 50);
        primaryStage.setTitle("Selection Sort Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateRandomArray() {
        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = i + 1;
        }
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int index1 = random.nextInt(ARRAY_SIZE);
            int index2 = random.nextInt(ARRAY_SIZE);
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
    }

    private void drawArray(Pane pane) {
        pane.getChildren().clear();
        rectangles = new Rectangle[ARRAY_SIZE];
        double width = WIDTH / ARRAY_SIZE;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            Rectangle rectangle = new Rectangle(i * width, HEIGHT - array[i] * HEIGHT / ARRAY_SIZE, width, array[i] * HEIGHT / ARRAY_SIZE);
            rectangle.setFill(isSorted || i > currentIndex ? Color.BLUE : Color.RED);
            if (i == currentIndex) {
                rectangle.setFill(Color.GREEN);
            }
            if (i == minIndex) {
                rectangle.setFill(Color.YELLOW);
            }
            rectangles[i] = rectangle;
            pane.getChildren().add(rectangle);
            Text text = new Text(i * width, HEIGHT - 10, String.valueOf(array[i]));
            pane.getChildren().add(text);
        }
    }

    private void step() {
        if (isSorted) {
            return;
        }
        if (currentIndex < ARRAY_SIZE - 1) {
            minIndex = currentIndex;
            for (int i = currentIndex + 1; i < ARRAY_SIZE; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            int temp = array[currentIndex];
            array[currentIndex] = array[minIndex];
            array[minIndex] = temp;
            currentIndex++;
            drawArray(new Pane());
            drawArray((Pane) rectangles[0].getParent());
        } else {
            isSorted = true;
            drawArray((Pane) rectangles[0].getParent());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
