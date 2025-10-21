package diettelGenericDataStructures;

import java.util.Scanner;

public class PostfixEvaluatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a postfix expression (space-separated): ");
        String postfixExpression = scanner.nextLine();

        PostfixEvaluator evaluator = new PostfixEvaluator(postfixExpression);
        try {
            double result = evaluator.evaluatePostfixExpression();
            System.out.println("Postfix Expression: " + postfixExpression);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Error evaluating expression: " + e.getMessage());
        }
    }
}
