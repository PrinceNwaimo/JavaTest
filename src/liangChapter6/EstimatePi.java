package liangChapter6;

public class EstimatePi {
    public static void main(String[] args) {
        System.out.println("i\tm(i)");
        for (int i = 1; i <= 901; i += 100) {
            double pi = estimatePi(i);
            System.out.printf("%d\t%.4f\n", i, pi);
        }
    }

    public static double estimatePi(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += 4 * Math.pow(-1, i + 1) / (2 * i - 1);
        }
        return sum;
    }

}
