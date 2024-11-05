package liang5;

    public class SmallestNSquare {
        public static void main(String[] args) {
            int n = 1;

            // Increment n until n^2 exceeds 12,000
            while (n * n <= 12000) {
                n++;
            }

            System.out.println("The smallest integer n such that n^2 > 12,000 is: " + n);
        }
    }


