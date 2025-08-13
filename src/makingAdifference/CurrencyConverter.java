package makingAdifference;
//import javax.money.Monetary;
//import javax.money.MonetaryAmount;
//import javax.money.convert.CurrencyConversion;
//import javax.money.convert.MonetaryConversions;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class CurrencyConverter {
//    public static void main(String[] args) {
//        // Get the currencies from the user
//        String fromCurrency = args[0];
//        String toCurrency = args[1];
//        double amount = Double.parseDouble(args[2]);
//
//        // Create a MonetaryAmount object
//        MonetaryAmount monetaryAmount = Monetary.getDefaultAmountFactory()
//                .setCurrency(fromCurrency)
//                .setNumber(amount)
//                .create();
//
//        // Get the currency conversion
//        CurrencyConversion conversion = MonetaryConversions.getConversion(toCurrency);
//
//        // Convert the monetary amount
//        MonetaryAmount convertedAmount = monetaryAmount.with(conversion);
//
//        // Print the result
//        System.out.println(amount + " " + fromCurrency + " = " + convertedAmount.getNumber() + " " + toCurrency);
//    }
//     <dependency>
//    <groupId>org.javamoney</groupId>
//    <artifactId>moneta</artifactId>
//    <version>1.4.2</version>
//</dependency>

    private Map<String, BigDecimal> exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", BigDecimal.valueOf(1.0));
        exchangeRates.put("EUR", BigDecimal.valueOf(0.88));
        exchangeRates.put("GBP", BigDecimal.valueOf(0.76));
        // Add more exchange rates as needed
    }

    public BigDecimal convert(String fromCurrency, String toCurrency, BigDecimal amount) {
        BigDecimal fromRate = exchangeRates.get(fromCurrency);
        BigDecimal toRate = exchangeRates.get(toCurrency);
        return amount.multiply(toRate).divide(fromRate, 2, BigDecimal.ROUND_HALF_UP);
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount: ");
        BigDecimal amount = scanner.nextBigDecimal();

        System.out.print("Enter the from currency (USD, EUR, GBP): ");
        String fromCurrency = scanner.next();

        System.out.print("Enter the to currency (USD, EUR, GBP): ");
        String toCurrency = scanner.next();

        BigDecimal result = converter.convert(fromCurrency, toCurrency, amount);
        System.out.println(amount + " " + fromCurrency + " = " + result + " " + toCurrency);
    }
}
