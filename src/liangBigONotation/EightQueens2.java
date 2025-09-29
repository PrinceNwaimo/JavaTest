package liangBigONotation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class EightQueens2 extends Application {
    private static final int SIZE = 8;
    private int[][] board = new int[SIZE][SIZE];
    private int solutionCount = 0;

    @Override
    public void start(Stage primaryStage) {
        HBox solutionsBox = new HBox(10);
        solutionsBox.setPadding(new Insets(10));

        search(0);

        ScrollPane scrollPane = new ScrollPane(solutionsBox);
        scrollPane.setFitToHeight(true);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(scrollPane);

        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setTitle("Eight Queens Solutions");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void search(int row) {
        if (row == SIZE) {
            displaySolution();
            solutionCount++;
        } else {
            for (int column = 0; column < SIZE; column++) {
                if (isValid(row, column)) {
                    board[row][column] = 1;
                    search(row + 1);
                    board[row][column] = 0;
                }
            }
        }
    }

    private boolean isValid(int row, int column) {
        for (int i = 0; i < row; i++) {
            if (board[i][column] == 1) {
                return false;
            }
        }

        int i = row - 1;
        int j = column - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }

        i = row - 1;
        j = column + 1;
        while (i >= 0 && j < SIZE) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    private void displaySolution() {
        GridPane solutionPane = new GridPane();
        solutionPane.setAlignment(Pos.CENTER);
        solutionPane.setPadding(new Insets(10));
        solutionPane.setHgap(5);
        solutionPane.setVgap(5);

        Label label = new Label("Solution " + (solutionCount + 1));
        label.setStyle("-fx-font-weight: bold");
        solutionPane.add(label, 0, 0, 8, 1);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Circle circle = new Circle(10);
                circle.setFill(board[i][j] == 1 ? Color.BLACK : Color.TRANSPARENT);
                solutionPane.add(circle, j, i + 1);
            }
        }

        HBox solutionBox = new HBox(10);
        solutionBox.getChildren().add(solutionPane);
        solutionBox.setAlignment(Pos.TOP_CENTER);

        solutionBox.getChildren().add(solutionPane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
