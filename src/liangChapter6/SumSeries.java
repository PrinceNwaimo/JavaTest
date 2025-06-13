package liangChapter6;

public class SumSeries {
    public static void main(String[] args) {
        System.out.println("i\tm(i)");
        for (int i = 1; i <= 20; i++) {
            double sum = sumSeries(i);
            System.out.printf("%d\t%.4f\n", i, sum);
        }
    }

    public static double sumSeries(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (double) i / (i + 1);
        }
        return sum;
    }

}
