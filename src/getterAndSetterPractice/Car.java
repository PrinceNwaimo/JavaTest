package getterAndSetterPractice;

public class Car {
    private String Model;
    private String Year;
    private double Price;

    private double discount;

    public Car(String model, String year, double price, double discount) {
        Model = model;
        Year = year;
        Price = price;
        if (price < 0)
            Price = 0;
        this.discount = discount;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
    public void setDiscount(double discount){
        this.discount = discount;
    }
    public double getDiscount(){
        return discount;
    }
    public double payment(){
        double cal = (Price * discount)/100;
        return Price - cal;
    }
}
