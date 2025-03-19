package joyceChapter5;

public class Apartment {
    private int apartmentNumber;
    private int bedrooms;
    private int baths;
    private double rent;

    public Apartment(int apartmentNumber, int bedrooms, int baths, double rent) {
        this.apartmentNumber = apartmentNumber;
        this.bedrooms = bedrooms;
        this.baths = baths;
        this.rent = rent;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getBaths() {
        return baths;
    }

    public double getRent() {
        return rent;
    }

}
