package liangMultiThreading;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMatrixMultiplication {
    private static final int THRESHOLD = 100;

    public static double[][] parallelMultiplyMatrix(double[][] a, double[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

        if (colsA != rowsB) {
            throw new RuntimeException("Matrix dimensions are incompatible for multiplication");
        }

        double[][] result = new double[rowsA][colsB];
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelMultiplyMatrixTask(a, b, result, 0, rowsA - 1));
        return result;
    }

    private static class ParallelMultiplyMatrixTask extends RecursiveAction {
        private double[][] a;
        private double[][] b;
        private double[][] result;
        private int low;
        private int high;

        public ParallelMultiplyMatrixTask(double[][] a, double[][] b, double[][] result, int low, int high) {
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
                    for (int j = 0; j < b[0].length; j++) {
                        for (int k = 0; k < a[0].length; k++) {
                            result[i][j] += a[i][k] * b[k][j];
                        }
                    }
                }
            } else {
                int mid = (low + high) / 2;
                ParallelMultiplyMatrixTask leftTask = new ParallelMultiplyMatrixTask(a, b, result, low, mid);
                ParallelMultiplyMatrixTask rightTask = new ParallelMultiplyMatrixTask(a, b, result, mid + 1, high);
                leftTask.fork();
                rightTask.compute();
                leftTask.join();
            }
        }
    }

    public static double[][] sequentialMultiplyMatrix(double[][] a, double[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

        if (colsA != rowsB) {
            throw new RuntimeException("Matrix dimensions are incompatible for multiplication");
        }

        double[][] result = new double[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
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
        double[][] sequentialResult = sequentialMultiplyMatrix(a, b);
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        double[][] parallelResult = parallelMultiplyMatrix(a, b);
        endTime = System.currentTimeMillis();
        System.out.println("Parallel time: " + (endTime - startTime) + "ms");
    }
}
