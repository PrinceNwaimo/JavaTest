package diettelStreams;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;



public class FileTypeSummary {
    public static void main(String[] args) {
        Path path = Paths.get("/path/to/directory");

        try {
            Map<String, Long> fileTypeCount = Files.list(path)
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .map(s -> s.substring(s.lastIndexOf('.') + 1))
                    .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

            fileTypeCount.forEach((fileType, count) -> System.out.println(fileType + ": " + count));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
