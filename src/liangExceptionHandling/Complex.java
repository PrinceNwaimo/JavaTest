package liangExceptionHandling;

public class Complex implements Cloneable{
    private double realPart;
    private double imaginaryPart;


    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public Complex(double realPart) {
        this(realPart, 0);
    }

    public Complex() {
        this(0, 0);
    }


    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
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

    public Complex multiply(Complex other) {
        double newRealPart = realPart * other.realPart - imaginaryPart * other.imaginaryPart;
        double newImaginaryPart = imaginaryPart * other.realPart + realPart * other.imaginaryPart;
        return new Complex(newRealPart, newImaginaryPart);
    }

    public Complex divide(Complex other) {
        double denominator = other.realPart * other.realPart + other.imaginaryPart * other.imaginaryPart;
        double newRealPart = (realPart * other.realPart + imaginaryPart * other.imaginaryPart) / denominator;
        double newImaginaryPart = (imaginaryPart * other.realPart - realPart * other.imaginaryPart) / denominator;
        return new Complex(newRealPart, newImaginaryPart);
    }

    public double abs() {
        return Math.sqrt(realPart * realPart + imaginaryPart * imaginaryPart);
    }


    @Override
    public String toString() {
        if (imaginaryPart == 0) {
            return String.valueOf(realPart);
        } else if (realPart == 0) {
            return imaginaryPart + "i";
        } else if (imaginaryPart > 0) {
            return realPart + " + " + imaginaryPart + "i";
        } else {
            return realPart + " - " + Math.abs(imaginaryPart) + "i";
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
