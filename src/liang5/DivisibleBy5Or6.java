package liang5;

    public class DivisibleBy5Or6 {
        public static void main(String[] args) {
            int count = 0; // To track the number of items printed per line

            for (int i = 100; i <= 200; i++) {
                // Check if divisible by 5 or 6 but not both
                if ((i % 5 == 0 || i % 6 == 0) && !(i % 5 == 0 && i % 6 == 0)) {
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


