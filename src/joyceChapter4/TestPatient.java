package joyceChapter4;

public class TestPatient {
    public static void main(String[] args) {
        Patient patient1 = new Patient();
        System.out.println("ID Number: " + patient1.getIdNumber());
        System.out.println("Age: " + patient1.getAge());
        System.out.println("Blood Type: " + patient1.getBloodData().getBloodType());
        System.out.println("Rh Factor: " + patient1.getBloodData().getRhFactor());


        BloodData bloodData = new BloodData("AB", -1);
        Patient patient2 = new Patient(1234, 30, bloodData);
        System.out.println("ID Number: " + patient2.getIdNumber());
        System.out.println("Age: " + patient2.getAge());
        System.out.println("Blood Type: " + patient2.getBloodData().getBloodType());
        System.out.println("Rh Factor: " + patient2.getBloodData().getRhFactor());
    }
}
