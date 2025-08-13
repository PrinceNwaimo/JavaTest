package diettel8;

public class Cylinder {
    private double radius;
    private double height;

    public Cylinder() {
        this.radius = 1;
        this.height = 1;
    }

    public Cylinder(double radius, double height) {
        setRadius(radius);
        setHeight(height);
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("Radius must be a positive number.");
            this.radius = 1;
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Height must be a positive number.");
            this.height = 1;
        }
    }

    public double getHeight() {
        return height;
    }

    public double calculateVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}
