package liang10;

import java.util.Scanner;

public class StackOfIntegers2 {
    private int[] elements;
    private int size;

    public StackOfIntegers2() {
        elements = new int[16];
        size = 0;
    }

    public void push(int value) {
        if (size >= elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = value;
    }

    public int pop() {
        return elements[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

 class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        StackOfIntegers2 stack = getPrimeFactors(number);

        System.out.print("Prime factors in decreasing order: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static StackOfIntegers2 getPrimeFactors(int number) {
        StackOfIntegers2 stack = new StackOfIntegers2();
        int divisor = 2;
        while (number > 1) {
            if (number % divisor == 0) {
                stack.push(divisor);
                number /= divisor;
            } else {
                divisor++;
            }
        }
        return stack;
    }
}
