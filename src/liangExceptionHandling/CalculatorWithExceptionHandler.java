package liangExceptionHandling;

import java.util.Scanner;

public class CalculatorWithExceptionHandler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an expression (e.g., 2 + 3): ");
        String num1 = scanner.next();
        String operator = scanner.next();
        String num2 = scanner.next();

        try {
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);

            switch (operator) {
                case "+":
                    System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
                    break;
                case "-":
                    System.out.println(number1 + " - " + number2 + " = " + (number1 - number2));
                    break;
                case "*":
                    System.out.println(number1 + " * " + number2 + " = " + (number1 * number2));
                    break;
                case "/":
                    if (number2 != 0) {
                        System.out.println(number1 + " / " + number2 + " = " + (number1 / number2));
                    } else {
                        System.out.println("Cannot divide by zero.");
                    }
                    break;
                default:
                    System.out.println("Invalid operator.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong operand type. Please enter numbers only.");
        }
    }
}
