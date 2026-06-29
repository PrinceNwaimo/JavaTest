package leetCodeProblems;

public class Tets {
    public static void main(String[] args) {
        System.out.println(toFahereint(10));
    }

    private  static double toFahereint(double cels) {
        double num = cels * (9 / 5) + 32;
        return num;
    }

}
