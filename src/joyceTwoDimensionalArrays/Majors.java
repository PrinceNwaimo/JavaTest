package joyceTwoDimensionalArrays;

import java.util.Scanner;

public class Majors {
    public enum Major {
        ACC, CHEM, CIS, ENG, HIS, PHYS
    }

    public static void main(String[] args) {
        System.out.println("Available majors:");
        for (Major major : Major.values()) {
            System.out.println(major);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a major (ACC, CHEM, CIS, ENG, HIS, PHYS): ");
        String majorName = scanner.nextLine().toUpperCase();

        try {
            Major major = Major.valueOf(majorName);
            System.out.println("College division: " + getDivision(major));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid major");
        }
    }

    private static String getDivision(Major major) {
        switch (major) {
            case ACC:
            case CIS:
                return "Business Division";
            case CHEM:
            case PHYS:
                return "Science Division";
            case ENG:
            case HIS:
                return "Humanities Division";
            default:
                return "";
        }
    }

}
