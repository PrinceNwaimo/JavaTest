package liangMultiThreading;

import javafx.application.Application;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SudokuSearchAnimation extends Application {
    private static final int SIZE = 9;
    private static final int CELL_SIZE = 50;
    private static int[][] grid = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };
    private static Text[][] cells = new Text[SIZE][SIZE];
    private static GridPane gridPane = new GridPane();
    private static Timeline timeline;
    private static int row = 0;
    private static int col = 0;

    @Override
    public void start(Stage primaryStage) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Text text = new Text();
                text.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20));
                if (grid[i][j] != 0) {
                    text.setText(String.valueOf(grid[i][j]));
                }
                cells[i][j] = text;
                gridPane.add(text, j, i);
            }
        }

        timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), e -> {
            if (solveSudoku()) {
                timeline.stop();
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Scene scene = new Scene(gridPane, SIZE * CELL_SIZE, SIZE * CELL_SIZE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static boolean solveSudoku() {
        if (row == SIZE) {
            return true;
        }

        if (grid[row][col] != 0) {
            if (col == SIZE - 1) {
                row++;
                col = 0;
            } else {
                col++;
            }
            return true;
        }

        for (int num = 1; num <= SIZE; num++) {
            if (isValid(row, col, num)) {
                grid[row][col] = num;
                cells[row][col].setText(String.valueOf(num));
                if (col == SIZE - 1) {
                    row++;
                    col = 0;
                } else {
                    col++;
                }
                return true;
            }
        }

        grid[row][col] = 0;
        cells[row][col].setText("");
        if (col == 0) {
            row--;
            col = SIZE - 1;
        } else {
            col--;
        }
        return false;
    }

    private static boolean isValid(int row, int col, int num) {
        // Check the row
        for (int i = 0; i < SIZE; i++) {
            if (grid[row][i] == num) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][col] == num) {
                return false;
            }
        }

        // Check the 3x3 box
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i + boxRow][j + boxCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
