package getterAndSetterPractice;

import java.util.Scanner;

public class HeartRateTest {
    public static void main(String[] args) {
        HeartRates cardio = new HeartRates("FirstName","LastName","Date of Birth");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first name here: ");
        String firstName = input.nextLine();
        cardio.setFirstName(firstName);
        System.out.println("Enter your last name here: ");
        String lastName = input.nextLine();
        cardio.setLastName(lastName);

        System.out.println("Enter you date of birth in this format (dd-MM-yyyy):  ");
        String dateOfBirth = input.nextLine();
        cardio.setDateOfBirth(dateOfBirth);
        int age = cardio.AgeCalculator(dateOfBirth);

        System.out.println("Enter range(in %): ");
        double range = input.nextDouble();
        System.out.println("Hello"+" "+ cardio.getFirstName()+" "+ cardio.getLastName());
        System.out.println("You are "+age+"years");
        System.out.println("Maximum HeartRate is "+cardio.MaxHeartRate());
        System.out.println("Target HeartRate is "+cardio.TargetHR(range));


    }
}
