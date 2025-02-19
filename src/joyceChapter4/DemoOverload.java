package joyceChapter4;

public class DemoOverload {
    public static void main(String[] args) {
        int month = 6, day = 24, year = 2025;
        displayDate(month);
        displayDate(month, day);
        displayDate(month, day, year);
    }
    public static void displayDate(int mm){
        System.out.println("Event date " + mm + "/8/2025");
    }
    public static void displayDate(int mm, int dd){
        System.out.println("Event date "+ mm + "/" + dd + "/2025");
    }
    public static void displayDate(int mm, int dd, int yy){
        System.out.println("Event date " + mm + "/" + dd + "/" + yy);
    }
}
