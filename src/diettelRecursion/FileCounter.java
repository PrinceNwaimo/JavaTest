package diettelRecursion;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public class FileCounter {
    private Map<String, Integer> fileTypes;

    public FileCounter() {
        fileTypes = new TreeMap<>();
    }

    public void countFiles(String directory) {
        File dir = new File(directory);
        countFiles(dir);
    }

    private void countFiles(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        countFiles(file);
                    } else {
                        String[] parts = file.getName().split("\\.");
                        String extension = parts[parts.length - 1].toLowerCase();
                        fileTypes.put(extension, fileTypes.getOrDefault(extension, 0) + 1);
                    }
                }
            }
        }
    }

    public void printFileTypes() {
        for (Map.Entry<String, Integer> entry : fileTypes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        FileCounter fileCounter = new FileCounter();
        fileCounter.countFiles("/path/to/directory");
        fileCounter.printFileTypes();
    }
}



