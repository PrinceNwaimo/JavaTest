package liangSetsAndMaps;

import java.net.URL;
import java.util.*;


public class WebCrawler {
    private Set<String> listOfTraversedURLs = new HashSet<>();
    private Queue<String> listOfPendingURLs = new LinkedList<>();

    public void crawl(String startingURL) {
        listOfPendingURLs.offer(startingURL);

        while (!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100) {
            String url = listOfPendingURLs.poll();
            if (!listOfTraversedURLs.contains(url)) {
                listOfTraversedURLs.add(url);
                System.out.println("Craw " + url);

                for (String s : getSubURLs(url)) {
                    if (!listOfTraversedURLs.contains(s)) {
                        listOfPendingURLs.offer(s);
                    }
                }
            }
        }
    }

    private Set<String> getSubURLs(String urlString) {
        Set<String> set = new HashSet<>();

        try {
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext()) {
                String line = input.nextLine();
                current = line.indexOf("http:", current);
                while (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) { // Ensure that a substring exists
                        set.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex);
                    } else {
                        current = -1; // Exit the loop if no valid URL found
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return set;
    }

    public static void main(String[] args) {
        new WebCrawler().crawl("https://www.cs.armstrong.edu/liang");
    }
}
