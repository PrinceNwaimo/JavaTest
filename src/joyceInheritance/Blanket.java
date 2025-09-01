package joyceInheritance;

public class Blanket {
    protected String size;
    protected String color;
    protected String material;
    protected double price;

    public Blanket() {
        this.size = "Twin";
        this.color = "white";
        this.material = "cotton";
        this.price = 30.00;
    }

    public void setSize(String size) {
        switch (size) {
            case "Twin":
                this.price = 30.00;
                break;
            case "Double":
                this.price = 40.00;
                break;
            case "Queen":
                this.price = 55.00;
                break;
            case "King":
                this.price = 70.00;
                break;
            default:
                this.size = "Twin";
                this.price = 30.00;
                return;
        }
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(String material) {
        switch (material) {
            case "cotton":
                this.price += 0;
                break;
            case "wool":
                this.price += 20;
                break;
            case "cashmere":
                this.price += 45;
                break;
            default:
                this.material = "cotton";
                this.price -= getMaterialPrice();
                return;
        }
        this.material = material;
    }

    private double getMaterialPrice() {
        switch (this.material) {
            case "wool":
                return 20;
            case "cashmere":
                return 45;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Size: " + size +
                "\nColor: " + color +
                "\nMaterial: " + material +
                "\nPrice: $" + String.format("%.2f", price);
    }
}
