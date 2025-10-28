package liangGraphs;

public class City2 implements Displayable2{
    private String name;
    private double x, y;

    public City2(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override public double getX() { return x; }
    @Override public double getY() { return y; }
    @Override public String getName() { return name; }
}

