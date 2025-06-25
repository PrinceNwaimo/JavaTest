package joyceArrays;

public class Purchase {
    private int invoiceNumber;
    private double saleAmount;
    private double salesTax;

    public Purchase(int invoiceNumber, double saleAmount) {
        this.invoiceNumber = invoiceNumber;
        this.saleAmount = saleAmount;
        this.salesTax = saleAmount * 0.05;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
        this.salesTax = saleAmount * 0.05;
    }

    public double getSalesTax() {
        return salesTax;
    }

    @Override
    public String toString() {
        return "Invoice Number: " + invoiceNumber +
                ", Sale Amount: $" + saleAmount +
                ", Sales Tax: $" + salesTax;
    }

}
