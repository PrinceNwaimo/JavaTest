package liang5;
    import java.util.Scanner;

    public class FindSalesAmount {
        public static void main(String[] args) {
            // Constants for base salary and commission rates
            final double BASE_SALARY = 5000;
            final double COMMISSION_RATE_1 = 0.08; // 8% for the first $5,000
            final double COMMISSION_RATE_2 = 0.10; // 10% for the next $5,000
            final double COMMISSION_RATE_3 = 0.12; // 12% for the remaining amount

            // Create a scanner object for user input
            Scanner scanner = new Scanner(System.in);

            // Prompt user to enter the desired commission amount
            System.out.print("Enter the commission sought: ");
            double commissionSought = scanner.nextDouble();

            // Calculate the required sales amount using a for loop
            double totalSalary = 0.0;
            double salesAmount = 0.0;

            // Loop until the total salary is greater than or equal to the desired commission
            for (salesAmount = 0; totalSalary < (BASE_SALARY + commissionSought); salesAmount += 0.01) {
                double commission = calculateCommission(salesAmount);
                totalSalary = BASE_SALARY + commission;
            }

            // Display the required sales amount
            System.out.printf("You need to generate sales of $%.2f to earn $%.2f in commission.%n", salesAmount, commissionSought);

            // Close the scanner
            scanner.close();
        }

        // Method to calculate the commission based on sales amount
        public static double calculateCommission(double salesAmount) {
            double commission = 0.0;

            // Calculate commission based on sales amount
            if (salesAmount <= 5000) {
                commission = salesAmount * 0.08;
            } else if (salesAmount <= 10000) {
                commission = 5000 * 0.08 + (salesAmount - 5000) * 0.10;
            } else {
                commission = 5000 * 0.08 + 5000 * 0.10 + (salesAmount - 10000) * 0.12;
            }

            return commission;
        }
    }


