package diettelGenericMethods;

public class PairDemo {

    // Generic Pair class
    public static class Pair<F, S> {
        private F first;
        private S second;

        // Constructor
        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        // Getters and Setters
        public F getFirst() {
            return first;
        }

        public void setFirst(F first) {
            this.first = first;
        }

        public S getSecond() {
            return second;
        }

        public void setSecond(S second) {
            this.second = second;
        }

        // String representation
        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    // Test the Pair class
    public static void main(String[] args) {
        Pair<Integer, String> idName = new Pair<>(101, "Alice");
        Pair<String, Double> productPrice = new Pair<>("Laptop", 999.99);
        Pair<String, String> countryCapital = new Pair<>("Nigeria", "Abuja");

        System.out.println("ID-Name Pair: " + idName);
        System.out.println("Product-Price Pair: " + productPrice);
        System.out.println("Country-Capital Pair: " + countryCapital);

        // Using setters
        idName.setFirst(102);
        idName.setSecond("Bob");

        System.out.println("\nAfter modification:");
        System.out.println("Updated ID-Name Pair: " + idName);

        // Accessing individual elements
        System.out.println("\nAccessing individual elements:");
        System.out.println("Product: " + productPrice.getFirst());
        System.out.println("Price: " + productPrice.getSecond());
    }
}

