package liangMultiThreading;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMatrixAddition {
    private static final int THRESHOLD = 100;

    public static double[][] parallelAddMatrix(double[][] a, double[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        double[][] result = new double[rows][cols];
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelAddMatrixTask(a, b, result, 0, rows - 1));
        return result;
    }

    private static class ParallelAddMatrixTask extends RecursiveAction {
        private double[][] a;
        private double[][] b;
        private double[][] result;
        private int low;
        private int high;

        public ParallelAddMatrixTask(double[][] a, double[][] b, double[][] result, int low, int high) {
            this.a = a;
            this.b = b;
            this.result = result;
            this.low = low;
            this.high = high;
        }

        @Override
        protected void compute() {
            if (high - low < THRESHOLD) {
                for (int i = low; i <= high; i++) {
                    for (int j = 0; j < a[0].length; j++) {
                        result[i][j] = a[i][j] + b[i][j];
                    }
                }
            } else {
                int mid = (low + high) / 2;
                ParallelAddMatrixTask leftTask = new ParallelAddMatrixTask(a, b, result, low, mid);
                ParallelAddMatrixTask rightTask = new ParallelAddMatrixTask(a, b, result, mid + 1, high);
                leftTask.fork();
                rightTask.compute();
                leftTask.join();
            }
        }
    }

    public static double[][] sequentialAddMatrix(double[][] a, double[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int size = 2000;
        double[][] a = new double[size][size];
        double[][] b = new double[size][size];

        // Initialize matrices with random values
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a[i][j] = Math.random();
                b[i][j] = Math.random();
            }
        }

        long startTime = System.currentTimeMillis();
        double[][] sequentialResult = sequentialAddMatrix(a, b);
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        double[][] parallelResult = parallelAddMatrix(a, b);
        endTime = System.currentTimeMillis();
        System.out.println("Parallel time: " + (endTime - startTime) + "ms");
    }
}
