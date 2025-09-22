package liangRecursion;

public class SumSeries2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            double sum = sumSeries(i);
            System.out.println("m(" + i + ") = " + sum);
        }
    }

    public static double sumSeries(int i) {
        if (i == 1) {
            return 1.0 / 2.0;
        } else {
            return (double) i / (i + 1) + sumSeries(i - 1);
        }
    }
}
