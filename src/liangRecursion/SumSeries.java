package liangRecursion;

public class SumSeries {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            double sum = sumSeries(i);
            System.out.println("m(" + i + ") = " + sum);
        }
    }

    public static double sumSeries(int i) {
        if (i == 1) {
            return 1.0;
        } else {
            return 1.0 / i + sumSeries(i - 1);
        }
    }
}
