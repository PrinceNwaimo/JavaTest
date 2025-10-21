package diettelGenericDataStructures;

import java.util.Stack;

public class InfixToPostfixConverter {
    private Stack<Character> stack;
    private String infix;
    private StringBuilder postfix;

    public InfixToPostfixConverter(String infix) {
        this.infix = infix + ")";
        this.stack = new Stack<>();
        this.postfix = new StringBuilder();
        stack.push('(');
    }

    public String convertToPostfix() {
        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c).append(" ");
            } else if (c == '(') {
                stack.push(c);
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && isOperator(stack.peek()) && precedence(c, stack.peek())) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(c);
            } else if (c == ')') {
                while (stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop(); // Discard '('
            }
        }
        return postfix.toString().trim();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%';
    }

    private boolean precedence(char op1, char op2) {
        int p1 = getPrecedence(op1);
        int p2 = getPrecedence(op2);
        return p1 <= p2;
    }

    private int getPrecedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
}
