package joyceChapter4;

public class CarInsurancePolicy {
    private int policyNumber;
    private int numPayments;
    private String residentCity;

    public CarInsurancePolicy(int num, int payments, String City) {
        policyNumber = num;
        numPayments = payments;
        residentCity = City;
    }

    public CarInsurancePolicy(int num, int payments) {
        this(num, payments,"NewCastle");
    }

    public CarInsurancePolicy(int num)
    {
        this(num, 2, "Mayfield");
    }
    public void display()
    {
        System.out.println("Policy #" + policyNumber + ". " +
                numPayments + " payments annually. Driver resides in " +
                residentCity + ".");
    }

}