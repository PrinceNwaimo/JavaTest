package diettelGenericDataStructures;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluator2 {
    private Stack<Long> stack;
    private String postfix;

    public PostfixEvaluator2(String postfix) {
        this.postfix = postfix;
        this.stack = new Stack<>();
    }

    public long evaluatePostfixExpression() {
        Scanner scanner = new Scanner(postfix);
        while (scanner.hasNext()) {
            String token = scanner.next();
            if (isNumeric(token)) {
                stack.push(Long.parseLong(String.valueOf(stack.pop())));
            } else if (isOperator(token.charAt(0))) {
                long op2 = stack.pop();
                long op1 = stack.pop();
                long result = calculate(op1, token.charAt(0), op2);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%';
    }

    private long calculate(long op1, char operator, long op2) {
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
                return (long) Math.pow(op1, op2);
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
