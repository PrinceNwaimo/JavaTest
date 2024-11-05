package liang5;

import java.util.Scanner;

public class StudentScores2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = input.nextInt();

        String highestScoringStudent = "";
        int highestScore = Integer.MIN_VALUE;

        String secondStudent = "";
        int secondScore = Integer.MIN_VALUE;

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student: "+(i + 1) + "name:");
            String name = input.next();
            System.out.print("Enter student"+ (i + 1) + "score: ");
            int score = input.nextInt();

            if(score > highestScore){
                secondScore = highestScore;
                secondStudent = highestScoringStudent;

                highestScore = score;
                highestScoringStudent = name;
            }
            else if (score > secondScore && score < highestScore){
                secondScore = score;
                secondStudent = name;
            }

        }
        System.out.println("\nStudent with highest score: ");
        System.out.println("Name: "+ highestScoringStudent);
        System.out.println("Score: "+ highestScore);

        System.out.println("\nStudent with  second highest score: ");
        System.out.println("Name: "+ secondStudent);
        System.out.println("Score: "+ secondScore);
    }
}
