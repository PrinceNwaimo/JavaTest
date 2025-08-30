package joyceInheritance;

public class Candle {
    private String color;
    private int height;
    protected double price;

    public Candle() {
        this.color = "";
        this.height = 0;
        this.price = 0;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        setPrice(height * 2);
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price;
    }
}
