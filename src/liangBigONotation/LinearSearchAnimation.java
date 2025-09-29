package liangBigONotation;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

import javafx.application.Application;

public class LinearSearchAnimation extends Application {
    private int[] array = new int[20];
    private int key;
    private int index = 0;
    private boolean found = false;
    private boolean finished = true;
    private Label statusLabel;
    private TextField keyField;
    private Button stepButton;
    private Button resetButton;
    private Pane pane;
    private Rectangle[] rectangles;

    @Override
    public void start(Stage primaryStage) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        for (int i = 0; i < array.length; i++) {
            int index = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }

        statusLabel = new Label("Enter a key and click Step");
        keyField = new TextField();
        stepButton = new Button("Step");
        resetButton = new Button("Reset");
        pane = new Pane();
        rectangles = new Rectangle[array.length];
        for (int i = 0; i < array.length; i++) {
            Rectangle rectangle = new Rectangle(i * 30, 200 - array[i] * 10, 20, array[i] * 10);
            rectangle.setFill(Color.WHITE);
            rectangle.setStroke(Color.BLACK);
            pane.getChildren().add(rectangle);
            rectangles[i] = rectangle;
        }

        stepButton.setOnAction(e -> {
            if (finished) {
                try {
                    key = Integer.parseInt(keyField.getText());
                } catch (NumberFormatException ex) {
                    statusLabel.setText("Invalid key");
                    return;
                }
                finished = false;
                keyField.setEditable(false);
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> step()));
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
            }
        });

        resetButton.setOnAction(e -> {
            finished = true;
            keyField.setEditable(true);
            index = 0;
            found = false;
            Random rand = new Random();
            for (int i = 0; i < array.length; i++) {
                array[i] = i + 1;
            }
            for (int i = 0; i < array.length; i++) {
                int index = rand.nextInt(array.length);
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
            for (int i = 0; i < array.length; i++) {
                rectangles[i].setHeight(array[i] * 10);
                rectangles[i].setY(200 - array[i] * 10);
                rectangles[i].setFill(Color.WHITE);
            }
            statusLabel.setText("Enter a key and click Step");
        });

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(stepButton, resetButton);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(statusLabel);
        borderPane.setCenter(pane);
        borderPane.setBottom(new HBox(10, keyField, hBox));
        borderPane.setPadding(new Insets(10));

        Scene scene = new Scene(borderPane, 600, 300);
        primaryStage.setTitle("Linear Search Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void step() {
        if (index < array.length) {
            if (array[index] == key) {
                rectangles[index].setFill(Color.RED);
                statusLabel.setText("Key found at index " + index);
                finished = true;
                found = true;
            } else {
                rectangles[index].setFill(Color.BLUE);
            }
            index++;
        } else {
            if (!found) {
                statusLabel.setText("Key not found");
            }
            finished = true;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
