package liangBinarySearchTree;
import java.io.*;

public class BitOutputStream implements Closeable {
    private FileOutputStream output;
    private int currentByte;
    private int numBitsFilled;

    public BitOutputStream(File file) throws IOException {
        output = new FileOutputStream(file);
        currentByte = 0;
        numBitsFilled = 0;
    }

    public void writeBit(char bit) throws IOException {
        writeBit(bit == '1' ? 1 : 0);
    }

    public void writeBit(int bit) throws IOException {
        currentByte = (currentByte << 1) | bit;
        numBitsFilled++;
        if (numBitsFilled == 8) {
            output.write(currentByte);
            numBitsFilled = 0;
            currentByte = 0;
        }
    }

    public void close() throws IOException {
        while (numBitsFilled != 0) {
            writeBit(0); // pad with zeros
        }
        output.close();
    }
}

