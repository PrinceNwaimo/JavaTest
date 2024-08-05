package chapterThree;

import java.util.Scanner;

public class FutureDate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter today's day: ");
        int day = input.nextInt();
        System.out.print("Enter the number of days elapsed since today: ");
        int elapsed = input.nextInt();

        Day(day);
        int cal = Day(day + elapsed);


    }
    public static int Day(int day){
        switch (day % 7){
            case 0 :
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");

        }
        return day;
    }
}
