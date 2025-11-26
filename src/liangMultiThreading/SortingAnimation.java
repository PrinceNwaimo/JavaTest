package liangMultiThreading;

import javafx.application.Application;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SortingAnimation extends Application {
    private static final int SIZE = 50;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int BAR_WIDTH = WIDTH / SIZE;
    private static final int BAR_HEIGHT = HEIGHT / SIZE;

    private int[] array = new int[SIZE];
    private Rectangle[] bars = new Rectangle[SIZE];
    private Pane pane = new Pane();
    private Timeline timeline;

    @Override
    public void start(Stage primaryStage) {
        for (int i = 0; i < SIZE; i++) {
            array[i] = i + 1;
        }
        shuffleArray();

        for (int i = 0; i < SIZE; i++) {
            Rectangle bar = new Rectangle(i * BAR_WIDTH, HEIGHT - array[i] * BAR_HEIGHT, BAR_WIDTH, array[i] * BAR_HEIGHT);
            bar.setFill(Color.LIGHTGRAY);
            pane.getChildren().add(bar);
            bars[i] = bar;
        }

        timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), e -> {
            // selectionSort();
            // insertionSort();
            bubbleSort();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void shuffleArray() {
        for (int i = 0; i < SIZE; i++) {
            int randomIndex = (int) (Math.random() * SIZE);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    private void selectionSort() {
        for (int i = 0; i < SIZE - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < SIZE; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
            updateBars(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void insertionSort() {
        for (int i = 1; i < SIZE; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
            updateBars(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void bubbleSort() {
        for (int i = 0; i < SIZE - 1; i++) {
            for (int j = 0; j < SIZE - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            updateBars(SIZE - i - 1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void updateBars(int sortedIndex) {
        for (int i = 0; i < SIZE; i++) {
            bars[i].setHeight(array[i] * BAR_HEIGHT);
            bars[i].setY(HEIGHT - array[i] * BAR_HEIGHT);
            if (i <= sortedIndex) {
                bars[i].setFill(Color.RED);
            } else {
                bars[i].setFill(Color.LIGHTGRAY);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
