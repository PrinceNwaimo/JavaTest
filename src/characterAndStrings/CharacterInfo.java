package characterAndStrings;

public class CharacterInfo {
    public static void main(String[] args) {
        char aChar = 'C';
        System.out.println("The character is " + aChar);
        if(Character.isUpperCase(aChar))
            System.out.println(aChar + " is uppercase");
        else
            System.out.println(aChar + " is not uppercase");
        if (Character.isLowerCase(aChar))
            System.out.println(aChar + " is lowercase");
        else
            System.out.println(aChar + " is not lowercase");
        aChar = Character.toLowerCase(aChar);
        System.out.println("After to lowercase(), aChar is " + aChar);
        aChar = Character.toUpperCase(aChar);
        System.out.println("After to Uppercase(), aChar is " + aChar);
        if (Character.isLetterOrDigit(aChar))
            System.out.println(aChar + "is a letter or digit");
        else
            System.out.println(aChar + " is neither a letter nor a digit");
        if(Character.isWhitespace(aChar))
            System.out.println(aChar + " is whitespace");
        else
            System.out.println(aChar + " is not a whitespace");
    }
}

