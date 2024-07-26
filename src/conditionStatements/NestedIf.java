package conditionStatements;

import java.util.Scanner;

public class NestedIf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a score");
        int score = input.nextInt();
        NestedIf(score);
        NestedIfElse(score);

    }
    private static void NestedIf(int score){
        if (score >= 90.0)
            System.out.print("A");
        else
        if (score >= 80.0)
            System.out.print("B");
        else
        if (score >= 70.0)
            System.out.print("C");
        else
        if (score >= 60.0)
            System.out.print("D");
        else
            System.out.print("F");

    }

    private static void NestedIfElse(int score){
        if (score >= 90.0)
            System.out.print("A");
        else if (score >= 80.0)
            System.out.print("B");
        else if (score >= 70.0)
            System.out.print("C");
        else if (score >= 60.0)
            System.out.print("D");
        else
            System.out.print("F");
    }
}
