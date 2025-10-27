package liangGraphs;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Pos;

import java.util.*;

public class NineTailGUI extends Application {

    private final int SIZE = 3; // 3x3 board
    private Rectangle[][] cells = new Rectangle[SIZE][SIZE];
    private boolean[][] heads = new boolean[SIZE][SIZE]; // true = Head (H)
    private TextArea output = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        // Initialize grid
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Rectangle rect = new Rectangle(60, 60);
                rect.setFill(Color.WHITE);
                rect.setStroke(Color.BLACK);
                final int r = i, c = j;
                rect.setOnMouseClicked(e -> flip(r, c, rect));
                grid.add(rect, c, i);
                cells[i][j] = rect;
                heads[i][j] = false; // All tails initially
            }
        }

        Button solveBtn = new Button("Solve");
        solveBtn.setOnAction(e -> solve());

        VBox layout = new VBox(10, grid, solveBtn, output);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(layout);
        primaryStage.setTitle("Nine Tails Puzzle Solver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void flip(int row, int col, Rectangle rect) {
        heads[row][col] = !heads[row][col];
        rect.setFill(heads[row][col] ? Color.RED : Color.WHITE);
    }

    private void solve() {
        String initialState = getStateString();
        output.clear();

        output.appendText("Initial state: " + initialState + "\n");

        NineTailModel model = new NineTailModel();
        List<Integer> path = model.getShortestPath(NineTailModel.getIndex(initialState.toCharArray()));

        output.appendText("Steps to solve:\n");
        for (int state : path) {
            char[] node = NineTailModel.getNode(state);
            output.appendText(Arrays.toString(node) + "\n");
        }
    }

    private String getStateString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                sb.append(heads[i][j] ? 'H' : 'T');
        return sb.toString();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

