package diettelStreams;

import java.util.Arrays;
import java.util.Comparator;

public class InvoiceTest {
    public static void main(String[] args) {
        Invoice[] invoices = new Invoice[] {
                new Invoice("83", "Electric sander", 7, 57.98),
                new Invoice("24", "Power saw", 18, 99.99),
                new Invoice("7", "Sledge hammer", 11, 21.50),
                new Invoice("77", "Hammer", 76, 11.99),
                new Invoice("39", "Lawn mower", 3, 79.50),
                new Invoice("68", "Screwdriver", 106, 6.99),
                new Invoice("56", "Jig saw", 21, 11.00),
                new Invoice("3", "Wrench", 34, 7.50)
        };

        // a) Sort by partDescription
        Arrays.stream(invoices)
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .forEach(System.out::println);

        System.out.println();

        // b) Sort by pricePerItem
        Arrays.stream(invoices)
                .sorted(Comparator.comparingDouble(Invoice::getPricePerItem))
                .forEach(System.out::println);

        System.out.println();

        // c) Map to partDescription and quantity, sort by quantity
        Arrays.stream(invoices)
                .map(invoice -> new Object[] {invoice.getPartDescription(), invoice.getQuantity()})
                .sorted(Comparator.comparing(obj -> (int) obj[1]))
                .forEach(obj -> System.out.println(obj[0] + ": " + obj[1]));

        System.out.println();

        // d) Map to partDescription and invoice value, sort by invoice value
        Arrays.stream(invoices)
                .map(invoice -> new Object[] {invoice.getPartDescription(), invoice.getInvoiceValue()})
                .sorted(Comparator.comparingDouble(obj -> (double) obj[1]))
                .forEach(obj -> System.out.println(obj[0] + ": $" + String.format("%.2f", obj[1])));

        System.out.println();

        // e) Select invoice values in the range $200 to $500
        Arrays.stream(invoices)
                .filter(invoice -> invoice.getInvoiceValue() >= 200 && invoice.getInvoiceValue() <= 500)
                .map(invoice -> new Object[] {invoice.getPartDescription(), invoice.getInvoiceValue()})
                .forEach(obj -> System.out.println(obj[0] + ": $" + String.format("%.2f", obj[1])));

        System.out.println();

        // f) Find any one invoice in which the partDescription contains the word "saw"
        Arrays.stream(invoices)
                .filter(invoice -> invoice.getPartDescription().toLowerCase().contains("saw"))
                .findFirst()
                .ifPresent(System.out::println);
    }
}
