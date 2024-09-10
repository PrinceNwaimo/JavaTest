package diettel4;

import java.util.Scanner;

public class AgeGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int total = 0;
        int gradeCounter = 0;

        System.out.print("Enter your age or press -1 to quit: ");
        int age = input.nextInt();

        while(age != -1) {
            total = total + age;
            gradeCounter = gradeCounter + 1;

            System.out.print("Enter your age or press one to quit: ");
            age = input.nextInt();
        }
        if (gradeCounter != 0){
            double average = (double) total/ gradeCounter;
            System.out.printf("%n Total of %d age entered is %d%n",gradeCounter,total);
            System.out.printf("Average age is now %.2f%n ",average);
        }
        else{
            System.out.print("No age input");
        }
    }
}
