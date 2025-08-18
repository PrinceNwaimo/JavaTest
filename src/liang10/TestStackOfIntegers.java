package liang10;

public class TestStackOfIntegers {
    public static void main(String[] args) {
        StackOfIntegers stack = new StackOfIntegers();
        for (int i = 0; i < 10; i++)
            stack.push(i);
        while (!stack.empty())
            System.out.println(stack.pop() + " ");


        String message = new String("java is goood");
        message.matches("\\d{3}-\\d{2}-\\d{4}");
        }

    }

