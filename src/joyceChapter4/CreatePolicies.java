package joyceChapter4;

public class CreatePolicies {
    public static void main(String[] args) {
        CarInsurancePolicy first = new CarInsurancePolicy(349);
        CarInsurancePolicy second = new CarInsurancePolicy(456,40);
        CarInsurancePolicy third = new CarInsurancePolicy(789,12,"Coventry");


        first.display();
        second.display();
        third.display();
    }
}
