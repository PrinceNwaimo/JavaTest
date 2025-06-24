package joyceArrays;

public class DemoSalesperson {
    public static void main(String[] args) {
        Salesperson[] salespeople = new Salesperson[10];

        for (int i = 0; i < salespeople.length; i++) {
            salespeople[i] = new Salesperson(9999, 0);
        }

        for (Salesperson salesperson : salespeople) {
            System.out.println(salesperson);
        }
    }

}
