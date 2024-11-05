package liang5;

    public class DivisibleBy5And6 {
        public static void main(String[] args) {
            int count = 0; // To keep track of how many numbers are printed per line

            for (int i = 100; i <= 1000; i++) {
                // Check if the number is divisible by both 5 and 6
                if (i % 5 == 0 && i % 6 == 0) {
                    System.out.print(i + " ");
                    count++;

                    // Start a new line after every 10 numbers
                    if (count % 10 == 0) {
                        System.out.println();
                    }
                }
            }
        }
    }


