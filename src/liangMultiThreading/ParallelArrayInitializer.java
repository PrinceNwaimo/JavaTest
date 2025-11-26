package liangMultiThreading;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelArrayInitializer {
    private static final int THRESHOLD = 10000;
    private static final int CHUNK_SIZE = 1000;

    public static void parallelAssignValues(double[] list) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelAssignTask(list, 0, list.length));
    }

    private static class ParallelAssignTask extends RecursiveAction {
        private double[] list;
        private int low;
        private int high;

        public ParallelAssignTask(double[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;
        }

        @Override
        protected void compute() {
            if (high - low < THRESHOLD) {
                Random random = new Random();
                for (int i = low; i < high; i++) {
                    list[i] = random.nextDouble();
                }
            } else {
                int mid = (low + high) / 2;
                ParallelAssignTask leftTask = new ParallelAssignTask(list, low, mid);
                ParallelAssignTask rightTask = new ParallelAssignTask(list, mid, high);
                leftTask.fork();
                rightTask.compute();
                leftTask.join();
            }
        }
    }

    public static void sequentialAssignValues(double[] list) {
        Random random = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = random.nextDouble();
        }
    }

    public static void main(String[] args) {
        int size = 9000000;
        double[] list = new double[size];

        long startTime = System.currentTimeMillis();
        sequentialAssignValues(list);
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential time: " + (endTime - startTime) + "ms");

        list = new double[size];
        startTime = System.currentTimeMillis();
        parallelAssignValues(list);
        endTime = System.currentTimeMillis();
        System.out.println("Parallel time: " + (endTime - startTime) + "ms");
    }
}
