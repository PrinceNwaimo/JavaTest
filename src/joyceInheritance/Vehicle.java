package joyceInheritance;

public abstract class Vehicle {
    private String powerSource;
    private int wheels;
    protected int price;

    public Vehicle(String powerSource, int wheels) {
        this.powerSource = powerSource;
        this.wheels = wheels;
        this.price = price;
    }

    public String getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(String powerSource) {
        this.powerSource = powerSource;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getPrice() {
        return price;
    }

    public abstract void setPrice(int price);
}
