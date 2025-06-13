package liangChapter6;

public class TemperatureConverter {
    public static void main(String[] args) {
        System.out.println("Celsius\tFahrenheit | Fahrenheit\tCelsius");
        for (int i = 0; i <= 8; i++) {
            double celsius = 40 - i;
            double fahrenheit = 120 - i * 10;
            System.out.printf("%.1f\t%.1f | %.1f\t%.2f\n", celsius, celsiusToFahrenheit(celsius), fahrenheit, fahrenheitToCelsius(fahrenheit));
        }
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (9.0 / 5) * celsius + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (5.0 / 9) * (fahrenheit - 32);
    }

}
