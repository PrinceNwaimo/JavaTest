package joyceExceptionHandling;

public class ThrowUsedCarException {
    public static void main(String[] args) {
        UsedCar[] cars = new UsedCar[7];
        String[][] carData = {
                {"1001", "Ford", "2000", "50000", "15000"},
                {"1002", "Honda", "2010", "70000", "20000"},
                {"1003", "Toyota", "2005", "40000", "18000"},
                {"100a", "Ford", "2000", "50000", "15000"},
                {"1004", "BMW", "2010", "70000", "20000"},
                {"1005", "Toyota", "1995", "40000", "18000"},
                {"1006", "Honda", "2015", "-1", "22000"}
        };

        for (String[] data : carData) {
            try {
                UsedCar car = new UsedCar(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Double.parseDouble(data[4]));
                System.out.println("Car created successfully: " + car);
                cars[Integer.parseInt(data[0]) - 1001] = car;
            } catch (UsedCarException e) {
                System.out.println("Error creating car: " + e.getMessage());
            }
        }

        System.out.println("\nList of valid cars:");
        for (UsedCar car : cars) {
            if (car != null) {
                System.out.println(car);
            }
        }
    }
}
