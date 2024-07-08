package chapterThree;

public class ReturnTypes {
    public static void main(String[] args) {
        System.out.println(calculateGross1(8,100.0));
    }
    public static double calculateGross1(double hours, double rate){
        double gross;
        gross = hours * rate;
        return gross;
    }
}
