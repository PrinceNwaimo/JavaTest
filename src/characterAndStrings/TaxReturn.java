package characterAndStrings;

public class TaxReturn {
    private String socialSecurityNumber;
    private String lastName;
    private String firstName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private double annualIncome;
    private char maritalStatus;
    private double taxLiability;

    public TaxReturn(String socialSecurityNumber, String lastName, String firstName, String streetAddress, String city, String state, String zipCode, double annualIncome, char maritalStatus) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.annualIncome = annualIncome;
        this.maritalStatus = Character.toUpperCase(maritalStatus);
        calculateTaxLiability();
    }

    private void calculateTaxLiability() {
        double taxRate = 0;
        if (maritalStatus == 'S') {
            if (annualIncome <= 20000) {
                taxRate = 0.15;
            } else if (annualIncome <= 50000) {
                taxRate = 0.22;
            } else {
                taxRate = 0.30;
            }
        } else if (maritalStatus == 'M') {
            if (annualIncome <= 20000) {
                taxRate = 0.14;
            } else if (annualIncome <= 50000) {
                taxRate = 0.20;
            } else {
                taxRate = 0.28;
            }
        }
        taxLiability = annualIncome * taxRate;
    }

    public void display() {
        System.out.println("Social Security Number: " + socialSecurityNumber);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Address: " + streetAddress + ", " + city + ", " + state + " " + zipCode);
        System.out.println("Annual Income: $" + annualIncome);
        System.out.println("Marital Status: " + (maritalStatus == 'S' ? "Single" : "Married"));
        System.out.println("Tax Liability: $" + taxLiability);
    }

}
