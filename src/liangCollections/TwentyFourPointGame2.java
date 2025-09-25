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


public class TwentyFourPointGame2 extends Application {
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
            cardsBox.getChildren().add(imageView);
        }

        Button shuffleButton = new Button("Shuffle");
        shuffleButton.setOnAction(e -> {
            shuffleCards();
            updateImageViews();
        });

        Button findButton = new Button("Find");
        findButton.setOnAction(e -> findExpression());

        expressionField = new TextField();
        Button verifyButton = new Button("Verify");
        verifyButton.setOnAction(e -> verifyExpression());

        HBox buttonsBox = new HBox(10);
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.getChildren().addAll(shuffleButton, findButton, expressionField, verifyButton);

        resultLabel = new Label();

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

    private void findExpression() {
        List<String> expressions = find24PointExpressions(currentCards);
        if (expressions.isEmpty()) {
            resultLabel.setText("No expression found.");
        } else {
            resultLabel.setText("Expression: " + expressions.get(0));
            expressionField.setText(expressions.get(0));
        }
    }

    private List<String> find24PointExpressions(List<Integer> currentCards) {
        List<String> expressions = new ArrayList<>();
        permute(currentCards, 0, expressions);
        return expressions;
    }

    private void permute(List<Integer> currentCards, int start, List<String> expressions) {
        if (start == 3) {
            findExpressions(currentCards.get(0), currentCards.get(1), currentCards.get(2), currentCards.get(3), "", expressions);
        } else {
            for (int i = start; i < 4; i++) {
                Collections.swap(currentCards, start, i);
                permute(currentCards, start + 1, expressions);
                Collections.swap(currentCards, start, i);
            }
        }
    }

    private void findExpressions(double a, double b, double c, double d, String expression, List<String> expressions) {
        findExpressionsHelper(a, b, c, d, expression, expressions, new double[]{a, b, c, d}, new boolean[]{false, false, false, false});
    }

    private void findExpressionsHelper(double a, double b, double c, double d, String expression, List<String> expressions, double[] nums, boolean[] used) {
        if (used[0] && used[1] && used[2] && used[3]) {
            if (Math.abs(nums[0] - 24) < 0.001) {
                expressions.add(expression);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (!used[i]) {
                used[i] = true;
                double temp = nums[i];
                nums[i] = getNum(i, a, b, c, d);
                findExpressionsHelper(a, b, c, d, getExpression(expression, i, a, b, c, d), expressions, nums, used);
                nums[i] = temp;
                used[i] = false;
            }
        }
    }

    private double getNum(int i, double a, double b, double c, double d) {
        switch (i) {
            case 0:
                return a;
            case 1:
                return b;
            case 2:
                return c;
            case 3:
                return d;
            default:
                return 0;
        }
    }

    private String getExpression(String expression, int i, double a, double b, double c, double d) {
        if (expression.isEmpty()) {
            return getNumString(i, a, b, c, d);
        }

        String numStr = getNumString(i, a, b, c, d);
        String newExpression = "(" + expression + "+" + numStr + ")";
        findExpressionsHelperAdd(a, b, c, d, newExpression, numStr);

        newExpression = "(" + expression + "-" + numStr + ")";
        findExpressionsHelperSubtract(a, b, c, d, newExpression, numStr);

        newExpression = "(" + expression + "*" + numStr + ")";
        findExpressionsHelperMultiply(a, b, c, d, newExpression, numStr);

        newExpression = "(" + expression + "/" + numStr + ")";
        findExpressionsHelperDivide(a, b, c, d, newExpression, numStr);

        return "";
    }

    private void findExpressionsHelperAdd(double a, double b, double c, double d, String expression, String numStr) {
        // Add expression to list if it evaluates to 24
    }

    private void findExpressionsHelperSubtract(double a, double b, double c, double d, String expression, String numStr) {
        // Add expression to list if it evaluates to 24
    }

    private void findExpressionsHelperMultiply(double a, double b, double c, double d, String expression, String numStr) {
        // Add expression to list if it evaluates to 24
    }

    private void findExpressionsHelperDivide(double a, double b, double c, double d, String expression, String numStr) {
        // Add expression to list if it evaluates to 24
    }

    private String getNumString(int i, double a, double b, double c, double d) {
        switch (i) {
            case 0:
                return String.valueOf(a);
            case 1:
                return String.valueOf(b);
            case 2:
                return String.valueOf(c);
            case 3:
                return String.valueOf(d);
            default:
                return "";
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

    // Other methods...

    public static void main(String[] args) {
        launch(args);
    }
}
