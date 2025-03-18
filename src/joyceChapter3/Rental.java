package joyceChapter3;

public class Rental {
    public final static int MINUTES_IN_HOUR = 60;
    public final static int HOURLY_RATE = 40;

    public Rental(String contractNumber, int hours) {
        this.contractNumber = contractNumber;
        this.hours = hours;
    }

    private String contractNumber;
    private int hours;
    private int extraMinutes;
    private double price;

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public void setHoursAndMinutes(int minutes) {
        hours = minutes / MINUTES_IN_HOUR;
        extraMinutes = minutes % MINUTES_IN_HOUR;
        price = (hours * HOURLY_RATE) + (extraMinutes * 1.0);
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public int getHours() {
        return hours;
    }

    public int getExtraMinutes() {
        return extraMinutes;
    }

    public double getPrice() {
        return price;
    }
}
