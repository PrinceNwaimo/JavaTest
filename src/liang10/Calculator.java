package liang10;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        String expression = input.nextLine();
        try {
            System.out.println(expression + " = " + evaluateExpression(expression));
        } catch (Exception ex) {
            System.out.println("Wrong expression: " + expression);
        }
    }

    public static int evaluateExpression(String expression) {
        expression = expression.replaceAll("\\s", "");
        int operand1 = getOperand(expression, 0);
        char operator = getOperator(expression, String.valueOf(operand1).length());
        int operand2 = getOperand(expression, Integer.parseInt(String.valueOf(operand1 = String.valueOf(operand1).length() + String.valueOf(operator).length())));
        return calculate(operand1, operator, operand2);
    }

    public static int getOperand(String expression, int index) {
        StringBuilder operand = new StringBuilder();
        while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
            operand.append(expression.charAt(index));
            index++;
        }
        return Integer.parseInt(operand.toString());
    }

    public static char getOperator(String expression, int index) {
        return expression.charAt(index);
    }

    public static int calculate(int operand1, char operator, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new RuntimeException("Invalid operator");
        }
    }
}
