package diettelGenericDataStructures;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluator {
    private Stack<Double> stack;
    private String postfix;

    public PostfixEvaluator(String postfix) {
        this.postfix = postfix;
        this.stack = new Stack<>();
    }

    public double evaluatePostfixExpression() {
        Scanner scanner = new Scanner(postfix);
        while (scanner.hasNext()) {
            String token = scanner.next();
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token.charAt(0))) {
                double op2 = stack.pop();
                double op1 = stack.pop();
                double result = calculate(op1, token.charAt(0), op2);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%';
    }

    private double calculate(double op1, char operator, double op2) {
        switch (operator) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                if (op2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return op1 / op2;
            case '^':
                return Math.pow(op1, op2);
            case '%':
                if (op2 == 0) {
                    throw new ArithmeticException("Modulus by zero");
                }
                return op1 % op2;
            default:
                throw new UnsupportedOperationException("Unsupported operator");
        }
    }
}
