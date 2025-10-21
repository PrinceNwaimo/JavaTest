package diettelGenericDataStructures;

import java.util.Scanner;

public class InfixToPostFixConverterTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String infixExpression = scanner.nextLine();

        InfixToPostfixConverter converter = new InfixToPostfixConverter(infixExpression);
        String postfixExpression = converter.convertToPostfix();

        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}
