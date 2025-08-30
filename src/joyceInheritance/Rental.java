package joyceInheritance;

public class Rental {
    private int contractNumber;
    private int minutes;
    private int equipmentType;
    private static final int PRICE_PER_HOUR = 40;
    private static final String[] EQUIPMENT_TYPES = {"Personal Watercraft", "Pontoon Boat", "Kayak", "Canoe", "Paddleboard", "Sailboat", "Fishing Boat", "Speedboat"};

    public Rental(int contractNumber, int minutes, int equipmentType) {
        this.contractNumber = contractNumber;
        this.minutes = minutes;
        this.equipmentType = equipmentType;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getEquipmentType() {
        return equipmentType;
    }

    public String getEquipmentTypeName() {
        return EQUIPMENT_TYPES[equipmentType - 1];
    }

    public double getPrice() {
        return (minutes / 60.0) * PRICE_PER_HOUR;
    }

    @Override
    public String toString() {
        return "Contract Number: " + contractNumber +
                "\nEquipment Type: " + getEquipmentTypeName() +
                "\nRental Time: " + minutes + " minutes" +
                "\nPrice: $" + String.format("%.2f", getPrice());
    }
}
