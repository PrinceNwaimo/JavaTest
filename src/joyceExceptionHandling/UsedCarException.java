package joyceExceptionHandling;

public class UsedCarException extends Exception{
    private String vin;

    public UsedCarException(String vin, String message) {
        super("VIN: " + vin + " - " + message);
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }
}
