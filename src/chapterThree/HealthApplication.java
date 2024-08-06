package chapterThree;


import java.util.Scanner;

public class HealthApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter weight in pounds: ");
        double weight = input.nextDouble();

        System.out.print("Enter height in inches: ");
        double height = input.nextDouble();

        System.out.print(" Enter feet: ");
        double feet = input.nextDouble();

        BMI(weight, height, feet);
    }

    public static void BMI( double weight, double inch, double feet) {

        final double KILOGRAMS_PER_POUND = 0.45359237;
        final double METRES_PER_INCH = 0.0254;

        double weightInKilograms = weight * KILOGRAMS_PER_POUND;
        double feetInches = (feet * 12) + inch;
        double heightInMetres = feetInches * METRES_PER_INCH;
        double bmi = weightInKilograms / (Math.pow(heightInMetres, 2));

        System.out.println("BMI is " + bmi);
        if (bmi < 18.5)
            System.out.println("Underweight");
        else if (bmi < 25) {
            System.out.println("Normal");
        } else if (bmi < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
