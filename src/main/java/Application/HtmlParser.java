package Application;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HtmlParser {

    public static void indexingSite() {
        Document document = null;
        try {
            document = Jsoup.connect("https://www.wilcor.net/customerlanding.cfm?i=i").get();
        } catch (IOException e) {
            System.err.println("Site doesn`t found. Please wait a minute. Application try again");
            try {
                Thread.sleep(25000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            indexingSite();
        }
        try {
            XLSWritter.createDocument();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert document != null;


        Elements listData = document.select("div.row");
        for (Element element : listData.select("a"))
            System.out.println(element.text());
    }

    public static void main(String[] args) throws InterruptedException {
        indexingSite();
    }
}
