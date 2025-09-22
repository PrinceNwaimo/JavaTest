package liangRecursion;

import java.io.File;
import java.util.Stack;

public class DirectorySize {
    public static void main(String[] args) {
        System.out.println("Enter a directory or a file: ");
        java.util.Scanner input = new java.util.Scanner(System.in);
        String directory = input.nextLine();
        System.out.println(getSize(new File(directory)) + " bytes");
    }

    public static long getSize(File file) {
        long size = 0;
        if (file.isDirectory()) {
            Stack<File> stack = new Stack<>();
            stack.push(file);
            while (!stack.isEmpty()) {
                File currentFile = stack.pop();
                File[] files = currentFile.listFiles();
                if (files != null) {
                    for (File f : files) {
                        if (f.isDirectory()) {
                            stack.push(f);
                        } else {
                            size += f.length();
                        }
                    }
                }
            }
        } else {
            size = file.length();
        }
        return size;
    }
}
