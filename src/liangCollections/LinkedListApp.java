package liangCollections;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListApp extends Application {
    private List<Double> numbers = new LinkedList<>();
    private TextArea textArea;

    @Override
    public void start(Stage primaryStage) {
        TextField inputField = new TextField();
        inputField.setPromptText("Enter a number");

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addNumber(inputField.getText()));

        Button sortButton = new Button("Sort");
        sortButton.setOnAction(e -> sortNumbers());

        Button shuffleButton = new Button("Shuffle");
        shuffleButton.setOnAction(e -> shuffleNumbers());

        Button reverseButton = new Button("Reverse");
        reverseButton.setOnAction(e -> reverseNumbers());

        textArea = new TextArea();
        textArea.setEditable(false);

        VBox root = new VBox(10);
        root.getChildren().addAll(inputField, addButton, sortButton, shuffleButton, reverseButton, textArea);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Linked List App");
        primaryStage.show();
    }

    private void addNumber(String input) {
        try {
            double number = Double.parseDouble(input);
            if (!numbers.contains(number)) {
                numbers.add(number);
                updateTextArea();
            }
        } catch (NumberFormatException e) {
            // Handle invalid input
        }
    }

    private void sortNumbers() {
        Collections.sort(numbers);
        updateTextArea();
    }

    private void shuffleNumbers() {
        Collections.shuffle(numbers);
        updateTextArea();
    }

    private void reverseNumbers() {
        Collections.reverse(numbers);
        updateTextArea();
    }

    private void updateTextArea() {
        StringBuilder sb = new StringBuilder();
        for (double number : numbers) {
            sb.append(number).append("\n");
        }
        textArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
