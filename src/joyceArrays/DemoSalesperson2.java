package joyceArrays;

public class DemoSalesperson2 {
    public static void main(String[] args) {
        Salesperson[] salespeople = new Salesperson[10];
        double sales = 25000;

        for (int i = 0; i < salespeople.length; i++) {
            salespeople[i] = new Salesperson(111 + i, sales);
            sales += 5000;
        }

        for (Salesperson salesperson : salespeople) {
            System.out.println(salesperson);
        }
    }

}
