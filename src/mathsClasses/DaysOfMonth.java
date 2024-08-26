package mathsClasses;

import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        System.out.print("Enter the first three letters of a month name: ");
        String month = scanner.next().toUpperCase();

        int days = 0;

        switch (month) {
            case "JAN":
                days = 31;
                break;
            case "FEB":
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            case "MAR":
                days = 31;
                break;
            case "APR":
                days = 30;
                break;
            case "MAY":
                days = 31;
                break;
            case "JUN":
                days = 30;
                break;
            case "JUL":
                days = 31;
                break;
            case "AUG":
                days = 31;
                break;
            case "SEP":
                days = 30;
                break;
            case "OCT":
                days = 31;
                break;
            case "NOV":
                days = 30;
                break;
            case "DEC":
                days = 31;
                break;
            default:
                System.out.println("Invalid month. Please enter the first three letters of a month name.");
                return;
        }

        System.out.println("The number of days in " + month + " " + year + " is: " + days);
    }

}

