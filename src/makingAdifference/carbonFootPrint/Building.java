package makingAdifference.carbonFootPrint;

public class Building implements CarbonFootprint{
    private double squareFootage;
    private int numOccupants;
    private boolean isCommercial;

    public Building(double squareFootage, int numOccupants, boolean isCommercial) {
        this.squareFootage = squareFootage;
        this.numOccupants = numOccupants;
        this.isCommercial = isCommercial;
    }

    @Override
    public double getCarbonFootprint() {
        if (isCommercial) {
            return squareFootage * 10;
        } else {
            return squareFootage * 5;
        }
    }

    @Override
    public String toString() {
        return "Building - Square Footage: " + squareFootage + ", Number of Occupants: " + numOccupants + ", Commercial: " + isCommercial;
    }
}

