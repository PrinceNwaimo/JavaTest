package liangMultiThreading;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EightQueensAnimation extends Application{
    private static final int SIZE = 8;
    private static int[] queens = new int[SIZE];
    private static GridPane gridPane = new GridPane();
    private static Rectangle[][] cells = new Rectangle[SIZE][SIZE];
    private static Timeline timeline;
    private static int row = 0;

    @Override
    public void start(Stage primaryStage) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Rectangle rectangle = new Rectangle(50, 50);
                if ((i + j) % 2 == 0) {
                    rectangle.setFill(Color.WHITE);
                } else {
                    rectangle.setFill(Color.BLACK);
                }
                cells[i][j] = rectangle;
                gridPane.add(rectangle, j, i);
            }
        }

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            if (search(row)) {
                timeline.stop();
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Scene scene = new Scene(gridPane, SIZE * 50, SIZE * 50);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static boolean search(int row) {
        if (row == SIZE) {
            return true;
        }

        for (int column = 0; column < SIZE; column++) {
            if (isValid(row, column)) {
                queens[row] = column;
                cells[row][column].setFill(Color.RED);
                if (search(row + 1)) {
                    return true;
                }
                cells[row][column].setFill((row + column) % 2 == 0 ? Color.WHITE : Color.BLACK);
            }
        }

        return false;
    }

    private static boolean isValid(int row, int column) {
        for (int i = 1; i <= row; i++) {
            if (queens[row - i] == column // Check column
                    || queens[row - i] == column - i // Check upleft diagonal
                    || queens[row - i] == column + i) // Check upright diagonal
                return false; // Check if a queen is placed in this column
        }
        return true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
