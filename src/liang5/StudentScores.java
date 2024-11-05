package liang5;

import java.util.Scanner;

public class StudentScores {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = input.nextInt();
        String highestScoringStudent = "";
        int highestScore = 0;

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter Student"+ (i + 1) + "name: ");
            String name = input.next();
            System.out.print("Enter student"+ (i + 1) + "score: ");
            int score = input.nextInt();

            if (score > highestScore){
                highestScore = score;
                highestScoringStudent = name;
            }

        }
        System.out.println("\nStudent with highest score: ");
        System.out.println("Name: "+ highestScoringStudent);
        System.out.println("Score: "+ highestScore);
    }

}