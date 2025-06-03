package characterAndStrings;

import java.util.Scanner;

public class PrepareTax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String socialSecurityNumber;
        while (true) {
            System.out.println("Enter Social Security number (999-99-9999):");
            socialSecurityNumber = scanner.nextLine();
            if (socialSecurityNumber.matches("\\d{3}-\\d{2}-\\d{4}")) {
                break;
            }
            System.out.println("Invalid Social Security number. Please try again.");
        }

        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter street address:");
        String streetAddress = scanner.nextLine();

        System.out.println("Enter city:");
        String city = scanner.nextLine();

        System.out.println("Enter state:");
        String state = scanner.nextLine();

        String zipCode;
        while (true) {
            System.out.println("Enter zip code (5 digits):");
            zipCode = scanner.nextLine();
            if (zipCode.matches("\\d{5}")) {
                break;
            }
            System.out.println("Invalid zip code. Please try again.");
        }

        double annualIncome;
        while (true) {
            System.out.println("Enter annual income:");
            annualIncome = scanner.nextDouble();
            scanner.nextLine(); // Consume newline left-over
            if (annualIncome >= 0) {
                break;
            }
            System.out.println("Invalid annual income. Please try again.");
        }

        char maritalStatus;
        while (true) {
            System.out.println("Enter marital status (S for single, M for married):");
            maritalStatus = scanner.nextLine().charAt(0);
            if (maritalStatus == 'S' || maritalStatus == 's' || maritalStatus == 'M' || maritalStatus == 'm') {
                break;
            }
            System.out.println("Invalid marital status. Please try again.");
        }

        TaxReturn taxReturn = new TaxReturn(socialSecurityNumber, lastName, firstName, streetAddress, city, state, zipCode, annualIncome, maritalStatus);
        taxReturn.display();

        scanner.close();
    }

}
