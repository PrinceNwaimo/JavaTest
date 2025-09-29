package liangBigONotation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.application.Application;

public class Suduko2 extends Application {
    private TextField[][] textFields = new TextField[9][9];
    private int[][] grid = new int[9][9];
    private int solutionCount = 0;
    private int[][] solution1 = new int[9][9];
    private int[][] solution2 = new int[9][9];

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField textField = new TextField();
                textField.setPrefColumnCount(2);
                textField.setAlignment(Pos.CENTER);
                gridPane.add(textField, j, i);
                textFields[i][j] = textField;
            }
        }

        Button solveButton = new Button("Solve");
        solveButton.setOnAction(e -> {
            solutionCount = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    String text = textFields[i][j].getText();
                    if (text.isEmpty()) {
                        grid[i][j] = 0;
                    } else {
                        grid[i][j] = Integer.parseInt(text);
                    }
                }
            }
            solve();
            Label label = new Label("Number of solutions: " + solutionCount);
            if (solutionCount > 0) {
                displaySolution(solution1, gridPane);
                if (solutionCount > 1) {
                    displaySolution(solution2, gridPane);
                }
            }
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(new HBox(10, solveButton));

        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("Sudoku");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void solve() {
        search(grid, 0, 0);
    }

    private boolean search(int[][] grid, int i, int j) {
        if (i == 9) {
            if (solutionCount == 0) {
                copyGrid(grid, solution1);
            } else if (solutionCount == 1) {
                copyGrid(grid, solution2);
            }
            solutionCount++;
            return true;
        }

        if (j >= 9) {
            return search(grid, i + 1, 0);
        }

        if (grid[i][j] != 0) {
            return search(grid, i, j + 1);
        }

        for (int number = 1; number <= 9; number++) {
            if (isValid(grid, i, j, number)) {
                grid[i][j] = number;
                if (search(grid, i, j + 1)) {
                    grid[i][j] = 0;
                    return true;
                }
                grid[i][j] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int[][] grid, int i, int j, int number) {
        for (int column = 0; column < 9; column++) {
            if (grid[i][column] == number) {
                return false;
            }
        }

        for (int row = 0; row < 9; row++) {
            if (grid[row][j] == number) {
                return false;
            }
        }

        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
                if (grid[row][col] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    private void copyGrid(int[][] source, int[][] target) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                target[i][j] = source[i][j];
            }
        }
    }

    private void displaySolution(int[][] solution, GridPane gridPane) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                textFields[i][j].setText(String.valueOf(solution[i][j]));
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
