package joyceChapter4;

public class Billing {
    public void computeBill(double price){
       double tax = 0.08 * price;
       double total = tax + price;
        System.out.println("Your amount is "+ total);
    }
    public void computeBill (double price, int quantity){
        double product = price * quantity;
        double tax = product * 0.08;
        double total = tax + product;
        System.out.println("Your amount is "+ total);
    }
    public void computeBill(double price, int quantity, double coupon){
        double product = price * quantity;
        double reduce = product - coupon;
        double tax = product * 0.08;
        double total = reduce + tax;
        System.out.println("Your amount is "+ total);
    }
}
