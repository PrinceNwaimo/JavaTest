package joyceInheritance;

public class Fiction extends Book{
    private static final double PRICE = 24.99;

    public Fiction(String title) {
        super(title);
        setPrice();
    }

    @Override
    public void setPrice() {
        price = PRICE;
    }
}
