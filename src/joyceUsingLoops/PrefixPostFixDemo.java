package joyceUsingLoops;

public class PrefixPostFixDemo {
    public static void main(String[] args) {
        int number, answer;
        number = 17;
        System.out.println("Before incrementing, number is "+ number);
        answer = ++number;
        System.out.println("After prefix increment, number is " + number);
        System.out.println(" and answer is " + answer);
        number = 17;
        System.out.println("Before incrementing, number is " + number);
        answer = number++;
        System.out.println("After postfix increment, number is " + number);
        System.out.println("and answer is "+ answer);
    }
}
