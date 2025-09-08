package joyceExceptionHandling;

public class UsedCar {
    private String vin;
    private String make;
    private int year;
    private int mileage;
    private double price;

    public UsedCar(String vin, String make, int year, int mileage, double price) throws UsedCarException {
        if (vin.length() != 4 || !vin.matches("\\d+")) {
            throw new UsedCarException(vin, "Invalid VIN. VIN should be 4 digits.");
        }
        if (!make.equalsIgnoreCase("Ford") && !make.equalsIgnoreCase("Honda") && !make.equalsIgnoreCase("Toyota")
                && !make.equalsIgnoreCase("Chrysler") && !make.equalsIgnoreCase("Other")) {
            throw new UsedCarException(vin, "Invalid make. Make should be Ford, Honda, Toyota, Chrysler, or Other.");
        }
        if (year < 1997 || year > 2017) {
            throw new UsedCarException(vin, "Invalid year. Year should be between 1997 and 2017.");
        }
        if (mileage < 0) {
            throw new UsedCarException(vin, "Invalid mileage. Mileage should not be negative.");
        }
        if (price < 0) {
            throw new UsedCarException(vin, "Invalid price. Price should not be negative.");
        }
        this.vin = vin;
        this.make = make;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    @Override
    public String toString() {
        return "VIN: " + vin + ", Make: " + make + ", Year: " + year + ", Mileage: " + mileage + ", Price: " + price;
    }
}
