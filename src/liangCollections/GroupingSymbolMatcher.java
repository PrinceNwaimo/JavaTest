package liangCollections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class GroupingSymbolMatcher {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java GroupingSymbolMatcher <filename>");
            return;
        }

        String filename = args[0];
        try {
            if (isValid(filename)) {
                System.out.println("The file " + filename + " has correct pairs of grouping symbols.");
            } else {
                System.out.println("The file " + filename + " does not have correct pairs of grouping symbols.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + filename + " not found.");
        }
    }

    public static boolean isValid(String filename) throws FileNotFoundException {
        Stack<Character> stack = new Stack<>();
        Scanner scanner = new Scanner(new File(filename));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (char c : line.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == '}' || c == ']') {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char openingSymbol = stack.pop();
                    if (!isMatching(openingSymbol, c)) {
                        return false;
                    }
                }
            }
        }

        scanner.close();
        return stack.isEmpty();
    }

    public static boolean isMatching(char openingSymbol, char closingSymbol) {
        return (openingSymbol == '(' && closingSymbol == ')') ||
                (openingSymbol == '{' && closingSymbol == '}') ||
                (openingSymbol == '[' && closingSymbol == ']');
    }
}
