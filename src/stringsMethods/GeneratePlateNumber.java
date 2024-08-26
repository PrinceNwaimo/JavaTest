package stringsMethods;

import java.util.Random;

public class GeneratePlateNumber {
    public static void main(String[] args) {
        Random random = new Random();

        // Generate three uppercase letters
        char letter1 = (char) ('A' + random.nextInt(26));
        char letter2 = (char) ('A' + random.nextInt(26));
        char letter3 = (char) ('A' + random.nextInt(26));

        // Generate four digits
        int digit1 = random.nextInt(10);
        int digit2 = random.nextInt(10);
        int digit3 = random.nextInt(10);
        int digit4 = random.nextInt(10);

        // Create the plate number
        String plateNumber = "" + letter1 + letter2 + letter3 + digit1 + digit2 + digit3 + digit4;

        System.out.println("Generated plate number: " + plateNumber);
    }

}
