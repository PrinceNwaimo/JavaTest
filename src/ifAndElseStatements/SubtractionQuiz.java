package ifAndElseStatements;

import java.util.Scanner;

public class SubtractionQuiz {
    public static void main(String[] args) {

        int number1 = (int)(Math.random() * 100);
        int number2 = (int)(Math.random() * 100);

        if(number1 < number2){
            int temp = number1;
            number1 = number2;
            number2 = temp;
//            This block of code simply means that if number1 < number2, swap number1 with number2.
        }
        System.out.print("What is "+ number1 + " - "+ number2 + "? ");
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();

        if (number1 - number2 == answer)
            System.out.println("You are correct!");
        else{
            System.out.println("OOPs!, your answer is wrong.");
            System.out.println(number1 + " - " + number2 + " should be " + (number1 - number2));
        }
    }
}
