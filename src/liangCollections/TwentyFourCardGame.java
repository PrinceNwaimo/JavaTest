package liangCollections;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class TwentyFourCardGame extends Application {
    private TextField tf1, tf2, tf3, tf4;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
        tf1 = new TextField();
        tf2 = new TextField();
        tf3 = new TextField();
        tf4 = new TextField();

        Button solveButton = new Button("Solve");
        solveButton.setOnAction(e -> solve());

        resultLabel = new Label();

        HBox hBox1 = new HBox(10);
        hBox1.getChildren().addAll(new Label("Number 1:"), tf1);
        hBox1.setAlignment(Pos.CENTER);

        HBox hBox2 = new HBox(10);
        hBox2.getChildren().addAll(new Label("Number 2:"), tf2);
        hBox2.setAlignment(Pos.CENTER);

        HBox hBox3 = new HBox(10);
        hBox3.getChildren().addAll(new Label("Number 3:"), tf3);
        hBox3.setAlignment(Pos.CENTER);

        HBox hBox4 = new HBox(10);
        hBox4.getChildren().addAll(new Label("Number 4:"), tf4);
        hBox4.setAlignment(Pos.CENTER);

        HBox hBox5 = new HBox(10);
        hBox5.getChildren().addAll(solveButton);
        hBox5.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4, hBox5, resultLabel);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("24-Point Game");
        primaryStage.show();
    }

    private void solve() {
        try {
            double num1 = Double.parseDouble(tf1.getText());
            double num2 = Double.parseDouble(tf2.getText());
            double num3 = Double.parseDouble(tf3.getText());
            double num4 = Double.parseDouble(tf4.getText());

            List<String> expressions = find24PointExpressions(num1, num2, num3, num4);
            if (expressions.isEmpty()) {
                resultLabel.setText("No solution");
            } else {
                resultLabel.setText("Solution: " + expressions.get(0));
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
        }
    }

    private List<String> find24PointExpressions(double num1, double num2, double num3, double num4) {
        List<String> expressions = new ArrayList<>();
        double[] nums = {num1, num2, num3, num4};
        permute(nums, 0, expressions);
        return expressions;
    }

    private void permute(double[] nums, int start, List<String> expressions) {
        if (start == 3) {
            findExpressions(nums[0], nums[1], nums[2], nums[3], "", expressions);
        } else {
            for (int i = start; i < 4; i++) {
                swap(nums, start, i);
                permute(nums, start + 1, expressions);
                swap(nums, start, i);
            }
        }
    }

    private void swap(double[] nums, int i, int j) {
        double temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

//    private void findExpressions(double a, double b, double c, double d, String expression, List<String> expressions) {
//        // Try all possible combinations of operators
//        checkExpression(a + b + c + d, expression + "(((" + a + "+" + b + ")+" + c + ")+" + d + ")", expressions);
//        checkExpression(a + b + c - d, expression + "(((" + a + "+" + b + ")+" + c + ")-" + d + ")", expressions);
//        checkExpression(a + b + c * d, expression + "(((" + a + "+" + b + ")+" + c + ")*" + d + ")", expressions);
//        checkExpression(a + b + c / d, expression + "(((" + a + "+" + b + ")+" + c + ")/" + d + ")", expressions);
//        // ... and so on for all possible combinations
//    }

    private void findExpressions(double a, double b, double c, double d, String expression, List<String> expressions) {
        findExpressionsHelper(new double[]{a, b, c, d}, 0, expression, expressions);
    }

    private void findExpressionsHelper(double[] nums, int index, String expression, List<String> expressions) {
        if (index == 3) {
            double result = calculate(nums[0], nums[1],nums[2],'w');
            if (Math.abs(result - 24) < 0.001) {
                expressions.add(expression);
            }
            return;
        }

        for (int i = index; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                double temp1 = nums[i];
                double temp2 = nums[j];
                nums[i] = calculate(temp1, temp2, nums[2], '+');
                nums[j] = 0;
                findExpressionsHelper(nums, index + 1, expression + "(" + temp1 + "+" + temp2 + ")", expressions);
                nums[i] = calculate(temp1, temp2, nums[2], '-');
                findExpressionsHelper(nums, index + 1, expression + "(" + temp1 + "-" + temp2 + ")", expressions);
                nums[i] = calculate(temp1, temp2, nums[2], '*');
                findExpressionsHelper(nums, index + 1, expression + "(" + temp1 + "*" + temp2 + ")", expressions);
                if (temp2 != 0) {
                    nums[i] = calculate(temp1, temp2, nums[2], '/');
                    findExpressionsHelper(nums, index + 1, expression + "(" + temp1 + "/" + temp2 + ")", expressions);
                }
                nums[i] = temp1;
                nums[j] = temp2;
            }
        }
    }


    private double calculate(double a, double b, double num, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                return 0;
        }
    }
}