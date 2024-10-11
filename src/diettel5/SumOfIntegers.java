package diettel5;

public class SumOfIntegers {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 3; i <= 30 ; i+= 3) {
            System.out.println(i);

            sum += i;

        }
        System.out.println("The sum of numbers is: "+ sum);
    }
}
