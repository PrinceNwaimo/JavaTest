package liangExceptionHandling;
import java.io.IOException;
import java.util.Scanner;


import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import javax.swing.text.Element;
import java.io.IOException;

public class WebCrawler2 {
    public static void main(String[] args) {
        String url = "http://cs.armstrong.edu/liang";
        String keyword = "Computer Programming";
//        crawl(url, keyword);
    }

//    private static void crawl(String url, String keyword) {
//        try {
//            Document document = Jsoup.connect(url).get();
//            String text = document.body().text();
//            if (text.toLowerCase().contains(keyword.toLowerCase())) {
//                System.out.println("Found keyword at: " + url);
//                return;
//            }
//            Elements links = document.select("a[href]");
//            for (Element link : links) {
//                String linkUrl = link.attr("abs:href");
//                if (!linkUrl.startsWith("http")) {
//                    continue;
//                }
//                crawl(linkUrl, keyword);
//            }
//        } catch (IOException e) {
//            System.out.println("Error crawling: " + url);
//        }
//    }
}
