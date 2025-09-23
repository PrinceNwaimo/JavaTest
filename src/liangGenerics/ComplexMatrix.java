package liangGenerics;

public class ComplexMatrix extends GenericMatrix<Complex> {
    @Override
    protected Complex add(Complex c1, Complex c2) {
        return c1.add(c2);
    }

    @Override
    protected Complex multiply(Complex c1, Complex c2) {
        return c1.multiply(c2);
    }

    @Override
    protected Complex zero() {
        return new Complex(0, 0);
    }

    public static void main(String[] args) {
        ComplexMatrix complexMatrix = new ComplexMatrix();
        Complex[][] matrix1 = {
                {new Complex(1, 2), new Complex(3, 4)},
                {new Complex(5, 6), new Complex(7, 8)}
        };
        Complex[][] matrix2 = {
                {new Complex(9, 10), new Complex(11, 12)},
                {new Complex(13, 14), new Complex(15, 16)}
        };

        Complex[][] resultAdd = complexMatrix.addMatrix(matrix1, matrix2);
        Complex[][] resultMultiply = complexMatrix.multiplyMatrix(matrix1, matrix2);

        System.out.println("Matrix Addition:");
        complexMatrix.printResult(matrix1, matrix2, resultAdd, '+');
        System.out.println("\nMatrix Multiplication:");
        complexMatrix.printResult(matrix1, matrix2, resultMultiply, '*');
    }
    public Complex[][] addMatrix(Complex[][] matrix1, Complex[][] matrix2) {
        // Check bounds
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new RuntimeException("Matrices do not have the same size");
        }

        Complex[][] result = new Complex[matrix1.length][matrix1[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = add(matrix1[i][j], matrix2[i][j]);
            }
        }
        return result;
    }

    public Complex[][] multiplyMatrix(Complex[][] matrix1, Complex[][] matrix2) {
        // Check bounds
        if (matrix1[0].length != matrix2.length) {
            throw new RuntimeException("Matrices do not have compatible size");
        }

        Complex[][] result = new Complex[matrix1.length][matrix2[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = zero();
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] = add(result[i][j], multiply(matrix1[i][k], matrix2[k][j]));
                }
            }
        }
        return result;
}
}