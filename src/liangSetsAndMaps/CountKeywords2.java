package liangSetsAndMaps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountKeywords2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java CountKeywords filename");
            System.exit(1);
        }

        Set<String> keywords = new HashSet<>();
        String[] keywordStrings = {
                "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally",
                "float", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
                "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp",
                "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void",
                "volatile", "while", "true", "false", "null"
        };

        for (String keyword : keywordStrings) {
            keywords.add(keyword);
        }

        int count = 0;
        boolean inComment = false;

        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                count += countKeywords(line, keywords, inComment);
                inComment = isInComment(line, inComment);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[0]);
            System.exit(1);
        }

        System.out.println("Number of keywords: " + count);
    }

    private static int countKeywords(String line, Set<String> keywords, boolean inComment) {
        int count = 0;
        String[] words = line.split("\\s+");

        for (String word : words) {
            if (word.startsWith("\"") && word.endsWith("\"")) {
                continue; // Skip strings
            }

            if (inComment) {
                if (word.contains("*/")) {
                    inComment = false;
                    word = word.substring(word.indexOf("*/") + 2);
                } else {
                    continue;
                }
            }

            if (word.contains("/*")) {
                if (word.contains("*/")) {
                    String subWord = word.substring(0, word.indexOf("/*"));
                    count += countKeyword(subWord, keywords);
                    subWord = word.substring(word.indexOf("*/") + 2);
                    count += countKeyword(subWord, keywords);
                } else {
                    inComment = true;
                    String subWord = word.substring(0, word.indexOf("/*"));
                    count += countKeyword(subWord, keywords);
                    break;
                }
            } else if (word.contains("//")) {
                break; // Skip line comments
            } else {
                count += countKeyword(word, keywords);
            }
        }

        return count;
    }

    private static boolean isInComment(String line, boolean inComment) {
        if (inComment) {
            if (line.contains("*/")) {
                return false;
            }
            return true;
        }
        return line.contains("/*") && !line.contains("*/");
    }

    private static int countKeyword(String word, Set<String> keywords) {
        if (word.matches("[a-zA-Z_][a-zA-Z0-9_]*") && keywords.contains(word)) {
            return 1;
        }
        return 0;
    }
}
