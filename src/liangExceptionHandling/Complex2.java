package liangExceptionHandling;

public class Complex2 {
    private double realPart;
    private double imaginaryPart;

    public Complex2(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
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
}
