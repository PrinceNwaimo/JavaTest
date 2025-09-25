package liangCollections;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Random;

public class HangmanGame extends Application {
    private String[] words = {"apple", "banana", "cherry", "date", "elderberry"};
    private String word;
    private char[] guessedWord;
    private int misses;
    private Label wordLabel;
    private Label messageLabel;
    private TextField guessField;
    private Circle head;
    private Line body;
    private Line leftArm;
    private Line rightArm;
    private Line leftLeg;
    private Line rightLeg;

    @Override
    public void start(Stage primaryStage) {
        word = words[new Random().nextInt(words.length)];
        guessedWord = new char[word.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '*';
        }
        misses = 0;

        wordLabel = new Label(new String(guessedWord));
        messageLabel = new Label("Guess a letter");

        guessField = new TextField();
        guessField.setOnAction(e -> guessLetter());

        head = new Circle(50, 50, 20);
        head.setFill(Color.WHITE);
        head.setStroke(Color.BLACK);

        body = new Line(50, 70, 50, 120);
        leftArm = new Line(50, 80, 30, 90);
        rightArm = new Line(50, 80, 70, 90);
        leftLeg = new Line(50, 120, 30, 140);
        rightLeg = new Line(50, 120, 70, 140);

        VBox root = new VBox(10);
        root.getChildren().addAll(wordLabel, guessField, messageLabel, head, body, leftArm, rightArm, leftLeg, rightLeg);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 200, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hangman Game");
        primaryStage.show();
    }

    private void guessLetter() {
        String guess = guessField.getText();
        if (guess.length() != 1) {
            messageLabel.setText("Please enter a single letter");
            return;
        }

        char letter = guess.charAt(0);
        boolean correct = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                guessedWord[i] = letter;
                correct = true;
            }
        }

        if (!correct) {
            misses++;
            drawHangman();
        }

        wordLabel.setText(new String(guessedWord));
        guessField.clear();

        if (isWordGuessed()) {
            messageLabel.setText("Congratulations! You won!");
            guessField.setDisable(true);
        } else if (misses >= 6) {
            messageLabel.setText("Game over! The word was " + word);
            guessField.setDisable(true);
        }
    }

    private void drawHangman() {
        switch (misses) {
            case 1:
                head.setFill(Color.BLACK);
                break;
            case 2:
                body.setStroke(Color.BLACK);
                break;
            case 3:
                leftArm.setStroke(Color.BLACK);
                break;
            case 4:
                rightArm.setStroke(Color.BLACK);
                break;
            case 5:
                leftLeg.setStroke(Color.BLACK);
                break;
            case 6:
                rightLeg.setStroke(Color.BLACK);
                break;
        }
    }

    private boolean isWordGuessed() {
        for (char c : guessedWord) {
            if (c == '*') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
