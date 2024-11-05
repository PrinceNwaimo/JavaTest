package liang5;


    public class LargestNCube {
        public static void main(String[] args) {
            int n = 1;

            // Increment n until n^3 reaches or exceeds 12,000
            while (n * n * n < 12000) {
                n++;
            }

            // We subtract 1 to get the last n where n^3 < 12,000
            n--;

            System.out.println("The largest integer n such that n^3 < 12,000 is: " + n);
        }
    }


