package joyceUsingIfAndElse;

public class Rental {
    private int contractNumber;
    private int hours;
    private int minutes;

    public int getContractNumber() {
        return contractNumber;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public Rental(int contractNumber, int hours, int minutes) {
        this.contractNumber = contractNumber;
        this.hours = hours;
        this.minutes = minutes;
    }

    public double calculatePrice() {
        double price = hours * 40;
        if (minutes > 0 && minutes <= 40) {
            price += minutes;
        } else if (minutes > 40) {
            price += 40 + ((minutes - 40) / 60) * 40;
        }
        return price;
    }

    public String toString() {
        return "Contract Number: " + contractNumber + "\nRental Time: " + hours + " hours and " + minutes + " minutes\nPrice: $" + String.format("%.2f", calculatePrice());
    }

}
