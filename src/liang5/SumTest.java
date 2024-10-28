package liang5;

public class SumTest {
    public static void main(String[] args) {
        double sum = 0;
        for (double i = 0.01; i <= 1.0 ; i = i+ 0.01) {
            sum += i;
            System.out.println("The sum is " + sum);
        }
    }
}
