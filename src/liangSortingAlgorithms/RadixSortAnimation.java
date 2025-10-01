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

public class RadixSortAnimation extends Application {
    private static final int ARRAY_SIZE = 20;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private int[] array = new int[ARRAY_SIZE];
    private int currentIndex = 0;
    private int currentDigit = 1;
    private int[][] buckets = new int[10][ARRAY_SIZE];
    private int[] bucketSizes = new int[10];
    private boolean isPlacing = true;
    private boolean isSorted = false;

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
            drawArray(pane);
            currentIndex = 0;
            currentDigit = 1;
            isPlacing = true;
            isSorted = false;
            for (int i = 0; i < 10; i++) {
                bucketSizes[i] = 0;
            }
        });

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(stepButton, resetButton);
        hBox.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBox);
        BorderPane.setMargin(hBox, new Insets(10));

        Scene scene = new Scene(borderPane, WIDTH, HEIGHT + 50);
        primaryStage.setTitle("Radix Sort Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateRandomArray() {
        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(1000);
        }
    }

    private void drawArray(Pane pane) {
        pane.getChildren().clear();
        double width = WIDTH / ARRAY_SIZE;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            Rectangle rectangle = new Rectangle(i * width, HEIGHT - array[i] * HEIGHT / 1000, width, array[i] * HEIGHT / 1000);
            if (i == currentIndex && isPlacing) {
                rectangle.setFill(Color.RED);
            } else {
                rectangle.setFill(Color.GREEN);
            }
            pane.getChildren().add(rectangle);
            Text text = new Text(i * width, HEIGHT - 10, String.valueOf(array[i]));
            pane.getChildren().add(text);
        }
        if (!isPlacing) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < bucketSizes[i]; j++) {
                    Rectangle rectangle = new Rectangle(i * WIDTH / 10 + j * WIDTH / 100, 0, WIDTH / 100, 20);
                    rectangle.setFill(Color.BLUE);
                    pane.getChildren().add(rectangle);
                    Text text = new Text(i * WIDTH / 10 + j * WIDTH / 100, 15, String.valueOf(buckets[i][j]));
                    pane.getChildren().add(text);
                }
            }
        }
    }

    private void step(Pane pane) {
        if (isSorted) {
            return;
        }
        if (isPlacing) {
            if (currentIndex < ARRAY_SIZE) {
                int digit = (array[currentIndex] / currentDigit) % 10;
                buckets[digit][bucketSizes[digit]] = array[currentIndex];
                bucketSizes[digit]++;
                currentIndex++;
                drawArray(pane);
            } else {
                isPlacing = false;
                currentIndex = 0;
                drawArray(pane);
            }
        } else {
            if (currentIndex < 10) {
                if (bucketSizes[currentIndex] > 0) {
                    array[currentIndex * bucketSizes[currentIndex - 1] + bucketSizes[currentIndex - 1]] = buckets[currentIndex][0];
                    bucketSizes[currentIndex]--;
                    for (int i = 0; i < bucketSizes[currentIndex]; i++) {
                        buckets[currentIndex][i] = buckets[currentIndex][i + 1];
                    }
                    currentIndex++;
                    if (currentIndex == 10) {
                        currentIndex = 0;
                        currentDigit *= 10;
                        if (currentDigit > 1000) {
                            isSorted = true;
                        }
                        isPlacing = true;
                        for (int i = 0; i < 10; i++) {
                            bucketSizes[i] = 0;
                        }
                    }
                    drawArray(pane);
                } else {
                    currentIndex++;
                    drawArray(pane);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
