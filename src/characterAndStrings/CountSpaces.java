package characterAndStrings;

public class CountSpaces {
    public static void main(String[] args) {
        String quote = "Believe you can and you're halfway there. - Theodore Roosevelt";
        int spaceCount = 0;

        for (char c : quote.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }

        System.out.println("Quote: " + quote);
        System.out.println("Total number of spaces: " + spaceCount);
    }

}
