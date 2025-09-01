package joyceInheritance.insurance;

public class Life extends Insurance{
    private static final double MONTHLY_FEE = 36;

    public Life() {
        super("Life");
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
