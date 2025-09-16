package joyceFiles;

import java.io.*;

public class ValidateCheckDigits {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("account_numbers.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("valid_account_numbers.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.length() == 6 && line.matches("\\d+")) {
                    int sum = 0;
                    for (int i = 0; i < 5; i++) {
                        sum += Character.getNumericValue(line.charAt(i));
                    }
                    int checkDigit = Character.getNumericValue(line.charAt(5));
                    if (checkDigit == sum % 10) {
                        System.out.println(line + " is valid.");
                        writer.write(line);
                        writer.newLine();
                    } else {
                        System.out.println(line + " is not valid.");
                    }
                } else {
                    System.out.println(line + " is not a valid six-digit account number.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
    }
}
