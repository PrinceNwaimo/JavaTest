package joyceInheritance;

public class DemoCandles {
    public static void main(String[] args) {
        Candle candle = new Candle();
        candle.setColor("White");
        candle.setHeight(10);
        System.out.println("Candle Details:");
        System.out.println("Color: " + candle.getColor());
        System.out.println("Height: " + candle.getHeight() + " inches");
        System.out.println("Price: $" + candle.getPrice());

        ScentedCandle scentedCandle = new ScentedCandle();
        scentedCandle.setColor("Red");
        scentedCandle.setScent("Rose");
        scentedCandle.setHeight(10);
        System.out.println("\nScented Candle Details:");
        System.out.println("Color: " + scentedCandle.getColor());
        System.out.println("Scent: " + scentedCandle.getScent());
        System.out.println("Height: " + scentedCandle.getHeight() + " inches");
        System.out.println("Price: $" + scentedCandle.getPrice());
    }
}
