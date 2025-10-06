package liangBinarySearchTree;
import java.util.*;

public class BinPackingLargestFirst {
    private static final int BIN_CAPACITY = 10;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of objects: ");
        int n = input.nextInt();

        double[] weights = new double[n];
        System.out.print("Enter the weights of the objects: ");
        for (int i = 0; i < n; i++) {
            weights[i] = input.nextDouble();
        }

        // Sort in descending order (largest first)
        Arrays.sort(weights);
        double[] sorted = new double[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = weights[n - 1 - i];
        }

        // Greedy bin packing
        ArrayList<ArrayList<Double>> containers = new ArrayList<>();
        for (double weight : sorted) {
            boolean placed = false;
            for (ArrayList<Double> container : containers) {
                double sum = 0;
                for (double w : container) sum += w;
                if (sum + weight <= BIN_CAPACITY) {
                    container.add(weight);
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                ArrayList<Double> newContainer = new ArrayList<>();
                newContainer.add(weight);
                containers.add(newContainer);
            }
        }

        // Display result
        for (int i = 0; i < containers.size(); i++) {
            System.out.print("Container " + (i + 1) + " contains objects with weight ");
            for (double w : containers.get(i)) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
        System.out.println("Total number of containers: " + containers.size());
    }
}

