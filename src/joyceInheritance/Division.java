package joyceInheritance;

public abstract class Division {
    protected String divisionName;
    protected String accountNumber;

    public Division(String divisionName, String accountNumber) {
        this.divisionName = divisionName;
        this.accountNumber = accountNumber;
    }

    public abstract void display();
}
