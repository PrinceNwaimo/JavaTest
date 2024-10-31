package liang5;

public class ConversionTables {
    public static void main(String[] args) {
        System.out.printf("%-10s %-10s | %-10s %-10s%n", "Kilograms", "Pounds", "Pounds", "Kilograms");

        // Loop for both tables side by side
        int poundsStart = 20;
        for (int kg = 1; kg <= 199; kg += 2) {
            double pounds = kg * 2.2;  // Convert kilograms to pounds
            double kgFromPounds = poundsStart * 0.45359237;  // Convert pounds to kilograms

            // Display row with formatted output
            System.out.printf("%-10d %-10.1f | %-10d %-10.2f%n", kg, pounds, poundsStart, kgFromPounds);

            poundsStart += 5;  // Increment pounds by 5 for the next row
        }
    }
}
