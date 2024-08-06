package chapterThree;

import java.util.Scanner;

public class FutureDate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter today's day: ");
        int day = input.nextInt();
        System.out.print("Enter the number of days elapsed since today: ");
        int elapsed = input.nextInt();

        String select = Calculate(day, elapsed);
        System.out.println(select);

    }

    public static String Calculate(int day, int elapsed){
         String val = ((Day(day)));
        String cal = (Day(day + elapsed));

        return "Today is "+val +" and the future day is "+cal;

    }
    public static String Day(int day){
        switch (day % 7){
            case 0 :
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return"Saturday";
        }
        return "invalid day";
    }
}
