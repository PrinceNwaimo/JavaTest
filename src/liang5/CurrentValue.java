package liang5;

public class CurrentValue {
    public static void main(String[] args) {

        double currentValue = 0.01;
        double sum = 0;
        for (int count = 0; count < 100; count++)
        sum += currentValue;
        currentValue += 0.01;
        System.out.println("The sum is "+ sum +", the current value is "+currentValue);
    }
}
