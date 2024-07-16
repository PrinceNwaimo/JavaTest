package GetterAndSetterPractice;

public class CarTest {
    public static void main(String[] args) {
        Car Mercedes = new Car("ML5000", "2025",10000,5.00);
        Car Audi = new Car("AUX", "2024",5000,7.00);

        System.out.println("Mercedes $ " +Mercedes.payment());
        System.out.println("Audi $ " + Audi.payment());
    }
}
