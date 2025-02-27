package joyceChapter4;

public class TestBloodData {
    public static void main(String[] args) {
        BloodData bloodData1 = new BloodData();
        System.out.println("Blood Type: " + bloodData1.getBloodType());
        System.out.println("Rh Factor: " + bloodData1.getRhFactor());

        BloodData bloodData2 = new BloodData("AB", -1);
        System.out.println("Blood Type: " + bloodData2.getBloodType());
        System.out.println("Rh Factor: " + bloodData2.getRhFactor());

        bloodData1.setBloodType("A");
        bloodData1.setRhFactor(-1);
        System.out.println("Updated Blood Type: " + bloodData1.getBloodType());
        System.out.println("Updated Rh Factor: " + bloodData1.getRhFactor());
    }
}
