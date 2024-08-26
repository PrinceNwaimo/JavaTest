package mathsClasses;

import java.util.Scanner;

public class StudentMajorAndStatus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter two characters (Major and Status): ");
        String input = scanner.next().toUpperCase();

        if (input.length() == 2) {
            char major = input.charAt(0);
            char status = input.charAt(1);

            String majorName = "";
            String statusName = "";

            switch (major) {
                case 'M':
                    majorName = "Mathematics";
                    break;
                case 'C':
                    majorName = "Computer Science";
                    break;
                case 'I':
                    majorName = "Information Technology";
                    break;
                default:
                    System.out.println("Invalid major. Please enter M, C, or I.");
                    return;
            }

            switch (status) {
                case '1':
                    statusName = "Freshman";
                    break;
                case '2':
                    statusName = "Sophomore";
                    break;
                case '3':
                    statusName = "Junior";
                    break;
                case '4':
                    statusName = "Senior";
                    break;
                default:
                    System.out.println("Invalid status. Please enter 1, 2, 3, or 4.");
                    return;
            }

            System.out.println("Major: " + majorName);
            System.out.println("Status: " + statusName);
        } else {
            System.out.println("Please enter exactly two characters.");
        }
    }

}
