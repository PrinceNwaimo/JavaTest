package joyceTwoDimensionalArrays;

public class CarDemo {
    public static void main(String[] args)
    {
        Car firstCar = new Car(2014, Model.MINIVAN, Color.BLUE);
        Car secondcar = new Car(2017, Model.CONVERTIBLE, Color.RED);
        firstCar.display();
        secondcar.display();
    }
}
