package diettelArrays;

public class VariableLengthArgumentList {
    public static void main(String[] args) {
        System.out.println("Average of 10, 20, 30: " + average(10, 20, 30));
        System.out.println("Average of 10, 20, 30, 40, 50: " + average(10, 20, 30, 40, 50));
        System.out.println("Average of 10: " + average(10));
        System.out.println("Average of no numbers: " + average());
    }

    public static double average(int... numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return (double) sum / numbers.length;
    }

}
