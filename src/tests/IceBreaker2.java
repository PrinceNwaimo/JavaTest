package tests;

public class IceBreaker2 {
        public static void main(String[] args) {
            function(-2, 5);
        }

        public static void function(int x, int y) {
            int product = 0; // Initialize the product to 0
            for (int i = 0; i < y; i++) {
                product += x;
            }
            System.out.println(product);
        }
    }

