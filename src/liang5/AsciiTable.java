package liang5;

public class AsciiTable {
    public static void main(String[] args) {
        final int START = 33; // ASCII value for '!'
        final int END = 126;  // ASCII value for '~'
        final int CHARACTERS_PER_LINE = 10;

        int count = 0; // To keep track of characters per line

        for (int i = START; i <= END; i++) {
            System.out.print((char) i + " ");
            count++;

            // When 10 characters are printed, move to a new line
            if (count % CHARACTERS_PER_LINE == 0) {
                System.out.println();
            }
        }
    }
}
