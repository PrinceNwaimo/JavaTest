package liang5;

import java.sql.SQLOutput;
import java.util.Scanner;

public class GuessNumberOneTime {
    public static void main(String[] args) {
        int number = (int)(Math.random() * 101);
        Scanner input = new Scanner(System.in);
        int guess = -1;

        while ( guess != number){
            System.out.print("\nEnter your guess: ");
            guess = input.nextInt();
            if (guess == number){
                System.out.println("Yes, the number is "+number);
            }
            else if (guess > number){
                System.out.println(" Your guess is too high");
            }
            else {
                System.out.println("Your guess is too low");
            }

        }

    }
}
