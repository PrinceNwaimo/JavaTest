package liangSetsAndMaps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CountKeywords3 {
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

        Map<String, Integer> keywordCount = new HashMap<>();
        for (String keyword : keywords) {
            keywordCount.put(keyword, 0);
        }

        try (Scanner scanner = new Scanner(new File(args[0]))) {
            boolean inComment = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (inComment) {
                    if (line.contains("*/")) {
                        line = line.substring(line.indexOf("*/") + 2);
                        inComment = false;
                    } else {
                        continue;
                    }
                }

                if (line.contains("/*")) {
                    if (line.contains("*/")) {
                        String subLine = line.substring(0, line.indexOf("/*"));
                        countKeywords(subLine, keywords, keywordCount);
                        subLine = line.substring(line.indexOf("*/") + 2);
                        countKeywords(subLine, keywords, keywordCount);
                    } else {
                        String subLine = line.substring(0, line.indexOf("/*"));
                        countKeywords(subLine, keywords, keywordCount);
                        inComment = true;
                    }
                } else if (line.contains("//")) {
                    String subLine = line.substring(0, line.indexOf("//"));
                    countKeywords(subLine, keywords, keywordCount);
                } else {
                    countKeywords(line, keywords, keywordCount);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[0]);
            System.exit(1);
        }

        for (Map.Entry<String, Integer> entry : keywordCount.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    private static void countKeywords(String line, Set<String> keywords, Map<String, Integer> keywordCount) {
        String[] words = line.split("\\s+|\\.|\\(|\\)|\\[|\\]|\\{|\\}|;|,|\\?|:");
        for (String word : words) {
            if (keywords.contains(word)) {
                keywordCount.put(word, keywordCount.get(word) + 1);
            }
        }
    }
}
