package liangFile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class AddressBook {
    private static final int NAME_SIZE = 32;
    private static final int STREET_SIZE = 32;
    private static final int CITY_SIZE = 20;
    private static final int STATE_SIZE = 2;
    private static final int ZIP_SIZE = 5;
    private static final int RECORD_SIZE = NAME_SIZE + STREET_SIZE + CITY_SIZE + STATE_SIZE + ZIP_SIZE;

    private RandomAccessFile raf;

    public AddressBook(String filename) throws IOException {
        raf = new RandomAccessFile(filename, "rw");
    }

    public void addRecord(String name, String street, String city, String state, String zip) throws IOException {
        raf.seek(raf.length());
        writeRecord(name, street, city, state, zip);
    }

    public void updateRecord(int index, String name, String street, String city, String state, String zip) throws IOException {
        raf.seek(index * RECORD_SIZE);
        writeRecord(name, street, city, state, zip);
    }

    public String[] retrieveRecord(int index) throws IOException {
        raf.seek(index * RECORD_SIZE);
        return readRecord();
    }

    private void writeRecord(String name, String street, String city, String state, String zip) throws IOException {
        writeFixedLengthString(name, NAME_SIZE);
        writeFixedLengthString(street, STREET_SIZE);
        writeFixedLengthString(city, CITY_SIZE);
        writeFixedLengthString(state, STATE_SIZE);
        writeFixedLengthString(zip, ZIP_SIZE);
    }

    private String[] readRecord() throws IOException {
        String name = readFixedLengthString(NAME_SIZE);
        String street = readFixedLengthString(STREET_SIZE);
        String city = readFixedLengthString(CITY_SIZE);
        String state = readFixedLengthString(STATE_SIZE);
        String zip = readFixedLengthString(ZIP_SIZE);
        return new String[] {name, street, city, state, zip};
    }

    private void writeFixedLengthString(String s, int size) throws IOException {
        byte[] bytes = new byte[size];
        byte[] temp = s.getBytes();
        System.arraycopy(temp, 0, bytes, 0, Math.min(temp.length, size));
        raf.write(bytes);
    }

    private String readFixedLengthString(int size) throws IOException {
        byte[] bytes = new byte[size];
        raf.read(bytes);
        return new String(bytes).trim();
    }

    public void close() throws IOException {
        raf.close();
    }
}
