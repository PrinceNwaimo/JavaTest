package liangSetsAndMaps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SyntaxHighlighting {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java SyntaxHighlighting javaFile htmlFile");
            System.exit(1);
        }

        String javaFile = args[0];
        String htmlFile = args[1];

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

        try (Scanner scanner = new Scanner(new File(javaFile));
             FileWriter writer = new FileWriter(htmlFile)) {

            writer.write("<html><body><pre>");

            boolean inComment = false;
            boolean inString = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                for (char c : line.toCharArray()) {
                    if (inComment) {
                        if (c == '*' && line.indexOf("*/", line.indexOf(c)) == line.indexOf(c) + 1) {
                            writer.write("<font color=\"green\">" + c + "/" + "</font>");
                            inComment = false;
                            line = line.substring(line.indexOf(c) + 2);
                            if (line.length() > 0) {
                                writer.write(line);
                            }
                            break;
                        } else {
                            writer.write("<font color=\"green\">" + c + "</font>");
                        }
                    } else if (inString) {
                        if (c == '"') {
                            writer.write("<font color=\"blue\">" + c + "</font>");
                            inString = false;
                        } else {
                            writer.write("<font color=\"blue\">" + c + "</font>");
                        }
                    } else if (c == '/' && line.indexOf("//", line.indexOf(c)) == line.indexOf(c)) {
                        writer.write("<font color=\"green\">" + line.substring(line.indexOf(c)) + "</font>");
                        break;
                    } else if (c == '/' && line.indexOf("/*", line.indexOf(c)) == line.indexOf(c)) {
                        writer.write("<font color=\"green\">" + c);
                        inComment = true;
                    } else if (c == '"') {
                        writer.write("<font color=\"blue\">" + c);
                        inString = true;
                    } else {
                        String word = String.valueOf(c);
                        if (keywords.contains(word)) {
                            writer.write("<font color=\"navy\"><b>" + c + "</b></font>");
                        } else {
                            writer.write(String.valueOf(c));
                        }
                    }
                }

                writer.write("<br>");
            }

            writer.write("</pre></body></html>");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + javaFile);
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + htmlFile);
            System.exit(1);
        }
    }
}
