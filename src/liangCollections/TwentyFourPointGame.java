package liangCollections;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TwentyFourPointGame extends Application {
    private static final int NUMBER_OF_CARDS = 4;
    private static final int NUMBER_OF_CARDS_IN_DECK = 52;

    private List<Integer> deck = new ArrayList<>();
    private List<Integer> currentCards = new ArrayList<>();
    private List<ImageView> imageViews = new ArrayList<>();

    private Label resultLabel;
    private TextField expressionField;

    @Override
    public void start(Stage primaryStage) {
        for (int i = 1; i <= NUMBER_OF_CARDS_IN_DECK; i++) {
            deck.add((i - 1) % 13 + 1);
        }

        shuffleCards();

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        HBox cardsBox = new HBox(10);
        cardsBox.setAlignment(Pos.CENTER);

        for (int i = 0; i < NUMBER_OF_CARDS; i++) {
            ImageView imageView = new ImageView(new Image(currentCards.get(i) + ".png"));
            imageView.setFitWidth(100);
            imageView.setFitHeight(150);
            imageViews.add(imageView);
            cardsBox.getChildren();

        }

        Button shuffleButton = new Button("Shuffle");
        shuffleButton.setOnAction(e -> {
            shuffleCards();
            updateImageViews();
        });

        expressionField = new TextField();
        Button verifyButton = new Button("Verify");
        verifyButton.setOnAction(e -> verifyExpression());

        resultLabel = new Label();

        HBox buttonsBox = new HBox(10);
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.getChildren().addAll(shuffleButton, expressionField, verifyButton);

        root.getChildren().addAll(cardsBox, buttonsBox, resultLabel);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("24-Point Game");
        primaryStage.show();
    }

    private void shuffleCards() {
        currentCards.clear();
        Collections.shuffle(deck);
        for (int i = 0; i < NUMBER_OF_CARDS; i++) {
            currentCards.add(deck.get(i));
        }
    }

    private void updateImageViews() {
        for (int i = 0; i < NUMBER_OF_CARDS; i++) {
            imageViews.get(i).setImage(new Image(currentCards.get(i) + ".png"));
        }
    }

    private void verifyExpression() {
        try {
            String expression = expressionField.getText();
            if (isValidExpression(expression)) {
                double result = evaluateExpression(expression);
                if (result == 24) {
                    resultLabel.setText("Correct!");
                } else {
                    resultLabel.setText("Incorrect. The result is " + result + ", not 24.");
                }
            } else {
                resultLabel.setText("Invalid expression.");
            }
        } catch (Exception e) {
            resultLabel.setText("Invalid expression.");
        }
    }

    private boolean isValidExpression(String expression) {
        // Check if the expression contains the numbers of the current cards
        for (int card : currentCards) {
            if (!expression.contains(String.valueOf(card))) {
                return false;
            }
        }

        // Check if the expression contains any invalid characters
        for (char c : expression.toCharArray()) {
            if (!Character.isDigit(c) && c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')') {
                return false;
            }
        }

        return true;
    }

    private double evaluateExpression(String expression) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expression.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = expression.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                return x;
            }
        }.parse();
    }
}
