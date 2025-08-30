package joyceInheritance;

public class ScentedCandle extends Candle{
    private String scent;

    public ScentedCandle() {
        super();
        this.scent = "";
    }

    public String getScent() {
        return scent;
    }

    public void setScent(String scent) {
        this.scent = scent;
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setPrice(height * 3);
    }
}
