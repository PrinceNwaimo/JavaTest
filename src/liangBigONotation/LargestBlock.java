package liangBigONotation;

import javafx.application.Application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Random;

public class LargestBlock extends Application {
    private TextField[][] textFields = new TextField[10][10];
    private int[][] matrix = new int[10][10];

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                TextField textField = new TextField();
                textField.setPrefColumnCount(2);
                textField.setAlignment(Pos.CENTER);
                gridPane.add(textField, j, i);
                textFields[i][j] = textField;
                matrix[i][j] = new Random().nextInt(2);
                textField.setText(String.valueOf(matrix[i][j]));
            }
        }

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    matrix[i][j] = new Random().nextInt(2);
                    textFields[i][j].setText(String.valueOf(matrix[i][j]));
                    textFields[i][j].setStyle("-fx-background-color: white");
                }
            }
        });

        Button findButton = new Button("Find Largest Block");
        findButton.setOnAction(e -> {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    matrix[i][j] = Integer.parseInt(textFields[i][j].getText());
                    textFields[i][j].setStyle("-fx-background-color: white");
                }
            }
            int maxSize = findLargestBlock();
            if (maxSize > 0) {
                for (int i = maxI; i < maxI + maxSize; i++) {
                    for (int j = maxJ; j < maxJ + maxSize; j++) {
                        textFields[i][j].setStyle("-fx-background-color: yellow");
                    }
                }
            }
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(new HBox(10, refreshButton, findButton));

        Scene scene = new Scene(borderPane, 400, 350);
        primaryStage.setTitle("Largest Block");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private int maxI, maxJ, maxSize = 0;

    private int findLargestBlock() {
        int[][] dp = new int[10][10];

        for (int i = 0; i < 10; i++) {
            dp[i][0] = matrix[i][0];
            if (dp[i][0] > 0) {
                maxSize = 1;
                maxI = i;
                maxJ = 0;
            }
        }
        for (int j = 0; j < 10; j++) {
            dp[0][j] = matrix[0][j];
            if (dp[0][j] > 0) {
                maxSize = 1;
                maxI = 0;
                maxJ = j;
            }
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    if (dp[i][j] > maxSize) {
                        maxSize = dp[i][j];
                        maxI = i - maxSize + 1;
                        maxJ = j - maxSize + 1;
                    }
                }
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        launch(args);
 }
}
