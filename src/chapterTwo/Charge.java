package chapterTwo;

public class Charge {
    private final double rx, ry;
    private final double q;

    public Charge(double rx, double ry, double q) {
        this.rx = rx;
        this.ry = ry;
        this.q = q;
    }
    public double potentialAt (double x, double y){
        double k = 8.99e09;
        double dx = x - rx;
        double dy = y - ry;
        return k * q / Math.sqrt(dx * dx + dy * dy);
    }
    public String toString(){
        return q + " at "+ "(" + rx + ", " + ry +" )";
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        Charge c1 = new Charge(0.51,0.63,21.3);
        Charge c2 = new Charge(0.13,0.94,81.9);
        double v1 = c1.potentialAt(x,y);
        double v2 = c1.potentialAt(x,y);

        System.out.printf("%.2e\n", (v1 + v2));
    }
}
