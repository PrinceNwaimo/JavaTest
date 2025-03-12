package tests;

import java.util.ArrayList;
import java.util.List;

// Question: Write me a function that takes 3 integers (a,b and c), and returns the multiples of the number c between an and b.

public class IceBreaker3 {
    public static void main(String[] args) {
    List<Integer>multiples = findMultiples(5,90,2);
        System.out.println(multiples);
    }
    public static List<Integer> findMultiples(int firstNumber, int secondNumber, int thirdNumber) {
        List<Integer> multiples = new ArrayList<>();

        if (firstNumber > secondNumber) {
            int temp = firstNumber;
            firstNumber = secondNumber;
            secondNumber = temp;
        }

        for (int i = firstNumber; i <= secondNumber; i++) {
            if (i % thirdNumber == 0) {
                multiples.add(i);
            }
        }

        return multiples;
    }
}


