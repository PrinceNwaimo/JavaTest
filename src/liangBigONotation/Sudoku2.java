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

import java.util.ArrayList;

public class Sudoku2 extends Application{
    private TextField[][] textFields = new TextField[9][9];
    private int[][] grid = new int[9][9];
    private ArrayList<int[][]> solutions = new ArrayList<>();
    private int solutionIndex = 0;
    private Button nextButton;
    private Label solutionLabel;

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
            solutions.clear();
            solutionIndex = 0;
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
            if (solutions.size() > 1) {
                nextButton.setVisible(true);
            } else {
                nextButton.setVisible(false);
            }
            solutionLabel.setText("Solution 1/" + solutions.size());
            displaySolution();
        });

        nextButton = new Button("Next");
        nextButton.setOnAction(e -> {
            solutionIndex = (solutionIndex + 1) % solutions.size();
            displaySolution();
            solutionLabel.setText("Solution " + (solutionIndex + 1) + "/" + solutions.size());
        });
        nextButton.setVisible(false);

        Button clearButton = new Button("Clear");
        clearButton.setOnAction(e -> {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    textFields[i][j].setText("");
                }
            }
            nextButton.setVisible(false);
            solutionLabel.setText("");
        });

        solutionLabel = new Label();

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(solveButton, nextButton, clearButton, solutionLabel);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("Sudoku");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void solve() {
        int[][] tempGrid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(grid[i], 0, tempGrid[i], 0, 9);
        }
        search(tempGrid);
    }

    private void search(int[][] grid) {
        int i = -1;
        int j = -1;
        boolean found = false;
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        if (!found) {
            int[][] solution = new int[9][9];
            for (i = 0; i < 9; i++) {
                System.arraycopy(grid[i], 0, solution[i], 0, 9);
            }
            solutions.add(solution);
            return;
        }

        for (int number = 1; number <= 9; number++) {
            if (isValid(grid, i, j, number)) {
                grid[i][j] = number;
                search(grid);
                grid[i][j] = 0;
            }
        }
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

    private void displaySolution() {
        int[][] solution = solutions.get(solutionIndex);
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
