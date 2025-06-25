package joyceArrays;

public class Rental {
    private String contractNumber;
    private int minutes;
    private double pricePerHour;
    private int equipmentType;
    private static final String[] EQUIPMENT_TYPES = {"personal watercraft", "pontoon boat", "rowboat", "canoe", "kayak", "beach chair", "umbrella", "other"};

    public Rental(String contractNumber, int minutes, double pricePerHour, int equipmentType) {
        this.contractNumber = contractNumber;
        this.minutes = minutes;
        this.pricePerHour = pricePerHour;
        setEquipmentType(equipmentType);
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public int getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(int equipmentType) {
        if (equipmentType >= EQUIPMENT_TYPES.length) {
            this.equipmentType = EQUIPMENT_TYPES.length - 1;
        } else {
            this.equipmentType = equipmentType;
        }
    }

    public String getEquipmentTypeName() {
        return EQUIPMENT_TYPES[equipmentType];
    }

    public double getTotalPrice() {
        return (minutes / 60.0) * pricePerHour;
    }

}
