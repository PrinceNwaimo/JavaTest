package liangChapter6;

public class RandomCharacter2 {
    /** Generate a random character between ch1 and ch2 */
    public static char getRandomCharacter(char ch1, char ch2) {
        return (char)(ch1 + Math.floor(Math.random() * (ch2 - ch1 + 1)));
    }

    /** Generate a random uppercase letter */
    public static char getRandomUppercaseLetter() {
        return getRandomCharacter('A', 'Z');
    }

    /** Generate a random digit character */
    public static char getRandomDigitCharacter() {
        return getRandomCharacter('0', '9');
    }

    public static void main(String[] args) {
        // Print 100 uppercase letters, 10 per line
        for (int i = 0; i < 100; i++) {
            System.out.print(getRandomUppercaseLetter() + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }

        System.out.println();

        // Print 100 single digits, 10 per line
        for (int i = 0; i < 100; i++) {
            System.out.print(getRandomDigitCharacter() + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }

}
