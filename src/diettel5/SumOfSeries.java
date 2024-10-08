package diettel5;

public class SumOfSeries {
    public static void main(String[] args) {
        System.out.println("n\tSum");
        long sum = 0;
        for (int n = 1; n <= 100; n++) {
            sum += n;
            System.out.println(n + "\t" + sum);
        }

    }
}