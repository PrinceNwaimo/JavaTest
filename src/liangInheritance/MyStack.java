package liangInheritance;

import java.util.ArrayList;
import java.util.Scanner;

public class MyStack extends ArrayList<Object> {
    public void push(Object o) {
        add(o);
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object o = get(size() - 1);
        remove(size() - 1);
        return o;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int getSize() {
        return size();
    }

    @Override
    public String toString() {
        return "stack: " + toString();
    }
}
 class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter five strings:");
        for (int i = 0; i < 5; i++) {
            stack.push(scanner.nextLine());
        }
        System.out.println("Strings in reverse order:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}