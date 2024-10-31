package liang5;

    public class Combinations {
        public static void main(String[] args) {
            int n = 7; // Total numbers from 1 to 7
            int count = 0; // Counter for total combinations

            System.out.println("All possible combinations of picking two numbers from 1 to 7:");

            // Loop through the first number
            for (int i = 1; i <= n; i++) {
                // Loop through the second number
                for (int j = i + 1; j <= n; j++) {
                    System.out.printf("%d, %d%n", i, j);
                    count++; // Increment the count of combinations
                }
            }

            // Display the total number of combinations
            System.out.println("Total number of combinations: " + count);
        }
    }


