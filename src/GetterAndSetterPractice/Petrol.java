package GetterAndSetterPractice;

public class Petrol {
    private String StationLocation;
    private String PetrolType;
    private int Quantity;
    private double PricePerLitre;
    private double PercentageDiscount;

    public Petrol(String stationLocation, String petrolType, int quantity, double pricePerLitre, double percentageDiscount) {
        StationLocation = stationLocation;
        PetrolType = petrolType;
        Quantity = quantity;
        PricePerLitre = pricePerLitre;
        PercentageDiscount = percentageDiscount;
    }

    public String getStationLocation() {
        return StationLocation;
    }

    public void setStationLocation(String stationLocation) {
        StationLocation = stationLocation;
    }

    public String getPetrolType() {
        return PetrolType;
    }

    public void setPetrolType(String petrolType) {
        PetrolType = petrolType;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getPricePerLitre() {
        return PricePerLitre;
    }

    public void setPricePerLitre(double pricePerLitre) {
        PricePerLitre = pricePerLitre;
    }

    public double getPercentageDiscount() {
        return PercentageDiscount;
    }

    public void setPercentageDiscount(double percentageDiscount) {
        PercentageDiscount = percentageDiscount;
    }
    public double getPurchaseAmount(){
        double pool = Quantity * PricePerLitre;
        double discount  = (PercentageDiscount * pool)/100;
         double amount = pool - discount;
        return amount;
    }
}
