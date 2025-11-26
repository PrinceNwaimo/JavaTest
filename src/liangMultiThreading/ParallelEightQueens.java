package liangMultiThreading;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelEightQueens {
    private static final int SIZE = 8;
    private static int[] queens = new int[SIZE];
    private static int count = 0;

    public static void parallelEightQueens() {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelEightQueensTask(0));
    }

    private static class ParallelEightQueensTask extends RecursiveAction {
        private int row;

        public ParallelEightQueensTask(int row) {
            this.row = row;
        }

        @Override
        protected void compute() {
            if (row == SIZE) {
                count++;
                printSolution();
            } else {
                for (int column = 0; column < SIZE; column++) {
                    if (isValid(row, column)) {
                        queens[row] = column;
                        if (row == 0) {
                            ParallelEightQueensTask task = new ParallelEightQueensTask(row + 1);
                            task.fork();
                        } else {
                            search(row + 1);
                        }
                    }
                }
            }
        }
    }

    private static boolean isValid(int row, int column) {
        for (int i = 1; i <= row; i++) {
            if (queens[row - i] == column // Check column
                    || queens[row - i] == column - i // Check upleft diagonal
                    || queens[row - i] == column + i) // Check upright diagonal
                return false; // Check if a queen is placed in this column
        }
        return true;
    }

    private static void printSolution() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (queens[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void search(int row) {
        if (row == SIZE) {
            count++;
            printSolution();
        } else {
            for (int column = 0; column < SIZE; column++) {
                if (isValid(row, column)) {
                    queens[row] = column;
                    search(row + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        parallelEightQueens();
        long endTime = System.currentTimeMillis();
        System.out.println("Total solutions: " + count);
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
