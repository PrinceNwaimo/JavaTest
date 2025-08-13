package diettel8;

public class Complex {
    private double realPart;
    private double imaginaryPart;

    public Complex() {
        this(0, 0);
    }

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public Complex add(Complex other) {
        double newRealPart = realPart + other.realPart;
        double newImaginaryPart = imaginaryPart + other.imaginaryPart;
        return new Complex(newRealPart, newImaginaryPart);
    }

    public Complex subtract(Complex other) {
        double newRealPart = realPart - other.realPart;
        double newImaginaryPart = imaginaryPart - other.imaginaryPart;
        return new Complex(newRealPart, newImaginaryPart);
    }

    @Override
    public String toString() {
        return String.format("(%f, %f)", realPart, imaginaryPart);
    }
}
