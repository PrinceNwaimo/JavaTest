package diettelArrays;

public class CommandLineAverage {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No command-line arguments provided.");
            return;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        try {
            for (String arg : args) {
                int number = Integer.parseInt(arg);
                if (number > max) {
                    max = number;
                }
                if (number < min) {
                    min = number;
                }
            }

            double average = (max + min) / 2.0;
            System.out.println("Maximum: " + max);
            System.out.println("Minimum: " + min);
            System.out.println("Average of maximum and minimum: " + average);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. All command-line arguments must be integers.");
        }
    }

}
