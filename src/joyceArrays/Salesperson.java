package joyceArrays;

public class Salesperson {
    private int idNumber;
    private double annualSales;

    public Salesperson(int idNumber, double annualSales) {
        this.idNumber = idNumber;
        this.annualSales = annualSales;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public double getAnnualSales() {
        return annualSales;
    }

    public void setAnnualSales(double annualSales) {
        this.annualSales = annualSales;
    }

    @Override
    public String toString() {
        return "Salesperson [ID: " + idNumber + ", Annual Sales: $" + annualSales + "]";
    }

}
