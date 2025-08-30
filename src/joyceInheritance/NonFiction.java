package joyceInheritance;

public class NonFiction extends Book{
    private static final double PRICE = 37.99;

    public NonFiction(String title) {
        super(title);
        setPrice();
    }

    @Override
    public void setPrice() {
        price = PRICE;
    }
}
