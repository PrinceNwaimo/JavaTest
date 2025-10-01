package liangSortingAlgorithms;

import javafx.application.Application;
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

public class MergeAnimation extends Application {
    private static final int ARRAY_SIZE = 8;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 200;
    private int[] list1 = new int[ARRAY_SIZE];
    private int[] list2 = new int[ARRAY_SIZE];
    private int[] temp = new int[ARRAY_SIZE * 2];
    private int index1 = 0;
    private int index2 = 0;
    private int tempIndex = 0;
    private boolean isFinished = false;

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        borderPane.setCenter(pane);

        generateRandomArrays();
        drawArrays(pane);

        Button stepButton = new Button("Step");
        stepButton.setOnAction(e -> step(pane));

        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e -> {
            generateRandomArrays();
            index1 = 0;
            index2 = 0;
            tempIndex = 0;
            isFinished = false;
            drawArrays(pane);
        });

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(stepButton, resetButton);
        hBox.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBox);
        BorderPane.setMargin(hBox, new Insets(10));

        Scene scene = new Scene(borderPane, WIDTH, HEIGHT + 50);
        primaryStage.setTitle("Merge Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateRandomArrays() {
        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            list1[i] = random.nextInt(500);
            list2[i] = random.nextInt(500) + 500;
        }
        java.util.Arrays.sort(list1);
        java.util.Arrays.sort(list2);
    }

    private void drawArrays(Pane pane) {
        pane.getChildren().clear();
        double width = WIDTH / (ARRAY_SIZE * 2);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            Rectangle rectangle = new Rectangle(i * width, 50, width, 20);
            rectangle.setFill(Color.GREEN);
            pane.getChildren().add(rectangle);
            Text text = new Text(i * width, 65, String.valueOf(list1[i]));
            pane.getChildren().add(text);
        }
        for (int i = 0; i < ARRAY_SIZE; i++) {
            Rectangle rectangle = new Rectangle((i + ARRAY_SIZE) * width, 50, width, 20);
            rectangle.setFill(Color.BLUE);
            pane.getChildren().add(rectangle);
            Text text = new Text((i + ARRAY_SIZE) * width, 65, String.valueOf(list2[i]));
            pane.getChildren().add(text);
        }
        for (int i = 0; i < tempIndex; i++) {
            Rectangle rectangle = new Rectangle(i * width, 100, width, 20);
            rectangle.setFill(Color.RED);
            pane.getChildren().add(rectangle);
            Text text = new Text(i * width, 115, String.valueOf(temp[i]));
            pane.getChildren().add(text);
        }
        if (isFinished) {
            Text text = new Text(WIDTH / 2 - 50, 150, "Merge Finished");
            pane.getChildren().add(text);
        }
    }

    private void step(Pane pane) {
        if (isFinished) {
            return;
        }
        if (index1 < ARRAY_SIZE && index2 < ARRAY_SIZE) {
            if (list1[index1] < list2[index2]) {
                temp[tempIndex] = list1[index1];
                index1++;
            } else {
                temp[tempIndex] = list2[index2];
                index2++;
            }
            tempIndex++;
        } else if (index1 < ARRAY_SIZE) {
            temp[tempIndex] = list1[index1];
            index1++;
            tempIndex++;
        } else if (index2 < ARRAY_SIZE) {
            temp[tempIndex] = list2[index2];
            index2++;
            tempIndex++;
        }
        if (tempIndex == ARRAY_SIZE * 2) {
            isFinished = true;
        }
        drawArrays(pane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
