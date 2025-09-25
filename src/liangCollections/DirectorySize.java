package liangCollections;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class DirectorySize {
    public static long getSize(File directory) {
        long size = 0;
        Queue<File> queue = new LinkedList<>();
        queue.offer(directory);

        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isFile()) {
                size += file.length();
            } else if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        queue.offer(f);
                    }
                }
            }
        }

        return size;
    }

    public static void main(String[] args) {
        File directory = new File("/path/to/directory");
        System.out.println("Size: " + getSize(directory));
    }
}

