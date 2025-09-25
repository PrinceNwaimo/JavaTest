package liangCollections;

import java.util.Stack;

public class PostfixEvaluator {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java PostfixEvaluator <postfix expression>");
            return;
        }

        String expression = args[0];
        try {
            double result = evaluatePostfix(expression);
            System.out.println("The result of the postfix expression is: " + result);
        } catch (Exception e) {
            System.out.println("Invalid postfix expression: " + e.getMessage());
        }
    }

    public static double evaluatePostfix(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new RuntimeException("Invalid postfix expression. Not enough operands for operator " + token);
                }

                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = applyOperator(operand1, operand2, token);
                stack.push(result);
            } else {
                try {
                    double operand = Double.parseDouble(token);
                    stack.push(operand);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Invalid operand: " + token);
                }
            }
        }

        if (stack.size() != 1) {
            throw new RuntimeException("Invalid postfix expression. Too many operands");
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static double applyOperator(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new RuntimeException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new RuntimeException("Invalid operator: " + operator);
        }
    }
}
