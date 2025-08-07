package joyceTwoDimensionalArrays;

public class Car {
    private int year;
    private Model model;

    public Car(int year, Model model, Color color) {
        this.year = year;
        this.model = model;
        this.color = color;
    }

    private Color color;

    public void display()
    {
        System.out.println("Car is a " + year + " " + color + " " + model);
    }
}
