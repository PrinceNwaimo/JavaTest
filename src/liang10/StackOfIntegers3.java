package liang10;

public class StackOfIntegers3 {
    private int[] elements;
    private int size;

    public StackOfIntegers3() {
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

class main {
    public static void main(String[] args) {
        StackOfIntegers3 stack = new StackOfIntegers3();

        for (int i = 2; i < 120; i++) {
            if (isPrime(i)) {
                stack.push(i);
            }
        }

        System.out.println("Prime numbers less than 120 in decreasing order:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
