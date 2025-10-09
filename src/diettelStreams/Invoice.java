package diettelStreams;

import java.util.Arrays;
import java.util.Comparator;

public class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public double getInvoiceValue() {
        return quantity * pricePerItem;
    }

    @Override
    public String toString() {
        return String.format("Part Number: %s, Part Description: %s, Quantity: %d, Price Per Item: %.2f",
                partNumber, partDescription, quantity, pricePerItem);
    }
}

