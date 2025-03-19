package joyceChapter5;

import java.util.Scanner;

public class AcmePay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter hours worked: ");
        double hoursWorked = scanner.nextDouble();

        System.out.println("Enter shift:");
        System.out.println("1. First shift ($17/hour)");
        System.out.println("2. Second shift ($18.50/hour)");
        System.out.println("3. Third shift ($22/hour)");
        int shift = scanner.nextInt();

        double hourlyRate = getHourlyRate(shift);
        double regularPay = calculateRegularPay(hoursWorked, hourlyRate);
        double overtimePay = calculateOvertimePay(hoursWorked, hourlyRate);
        double grossPay = regularPay + overtimePay;

        double retirementDeduction = 0;
        if (shift == 2 || shift == 3) {
            System.out.print("Elect retirement plan? (y/n): ");
            char response = scanner.next().charAt(0);
            if (response == 'y' || response == 'Y') {
                retirementDeduction = calculateRetirementDeduction(grossPay);
            }
        }

        double netPay = grossPay - retirementDeduction;

        System.out.println("\nPayroll Summary:");
        System.out.println("-------------------");
        System.out.println("Hours worked: " + hoursWorked);
        System.out.println("Shift: " + getShiftDescription(shift));
        System.out.println("Hourly rate: $" + hourlyRate);
        System.out.println("Regular pay: $" + regularPay);
        System.out.println("Overtime pay: $" + overtimePay);
        System.out.println("Gross pay: $" + grossPay);
        System.out.println("Retirement deduction: $" + retirementDeduction);
        System.out.println("Net pay: $" + netPay);
    }

    private static double getHourlyRate(int shift) {
        switch (shift) {
            case 1:
                return 17;
            case 2:
                return 18.50;
            case 3:
                return 22;
            default:
                return 0;
        }
    }

    private static double calculateRegularPay(double hoursWorked, double hourlyRate) {
        if (hoursWorked <= 40) {
            return hoursWorked * hourlyRate;
        } else {
            return 40 * hourlyRate;
        }
    }

    private static double calculateOvertimePay(double hoursWorked, double hourlyRate) {
        if (hoursWorked > 40) {
            return (hoursWorked - 40) * hourlyRate * 1.5;
        } else {
            return 0;
        }
    }

    private static double calculateRetirementDeduction(double grossPay) {
        return grossPay * 0.03;
    }

    private static String getShiftDescription(int shift) {
        switch (shift) {
            case 1:
                return "First shift";
            case 2:
                return "Second shift";
            case 3:
                return "Third shift";
            default:
                return "Unknown shift";
        }

    }
}