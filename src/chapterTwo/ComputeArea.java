package chapterTwo;

public class ComputeArea {
    public static void main(String[] args) {
        double radius;
        double area;

        radius = 20;
        area = radius * radius * 3.14159;
        System.out.println(" The area of the circle of radius  " + radius + " is " + area);
         test();
    }

    public static void test(){
        double i = 50.0;
        double k = i + 50.0;
        double j = k + 1;

        System.out.println(" J is " + j + " and k is " + k);
    }
}
