package joyceInheritance.insurance;

public class Health extends Insurance{
    private static final double MONTHLY_FEE = 196;

    public Health() {
        super("Health");
        setCost();
    }

    @Override
    public void setCost() {
        monthlyPrice = MONTHLY_FEE;
    }

    @Override
    public void display() {
        System.out.println("Type: " + type);
        System.out.println("Monthly Price: $" + monthlyPrice);
    }
}
