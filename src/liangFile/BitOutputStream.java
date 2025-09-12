package liangFile;

import java.io.FileOutputStream;
import java.io.IOException;

public class BitOutputStream {
    private FileOutputStream output;
    private int byteValue;
    private int bitCount;

    public BitOutputStream(String filename) throws IOException {
        output = new FileOutputStream(filename);
        byteValue = 0;
        bitCount = 0;
    }

    public void writeBit(char bit) throws IOException {
        byteValue = (byteValue << 1);
        if (bit == '1') {
            byteValue |= 1;
        }
        bitCount++;
        if (bitCount == 8) {
            output.write(byteValue);
            byteValue = 0;
            bitCount = 0;
        }
    }

    public void close() throws IOException {
        if (bitCount > 0) {
            byteValue = byteValue << (8 - bitCount);
            output.write(byteValue);
        }
        output.close();
    }

    public static void main(String[] args) throws IOException {
        BitOutputStream bos = new BitOutputStream("Exercise17_17.dat");
        String bits = "010000100100001001101";
        for (char bit : bits.toCharArray()) {
            bos.writeBit(bit);
        }
        bos.close();
        System.out.println("Bits written to Exercise17_17.dat");
    }
}
