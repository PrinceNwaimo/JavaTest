package joyceTwoDimensionalArrays;

public class Salesperson {
    private int id;
    private double sales;

    public Salesperson(int id, double sales) {
        this.id = id;
        this.sales = sales;
    }

    public Salesperson() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Sales: " + sales;
    }

}
