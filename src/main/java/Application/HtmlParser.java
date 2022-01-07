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
            document = Jsoup.connect("https://en.wikipedia.org/wiki/Conjunctive_normal_form").get();
        } catch (IOException e) {
            System.err.println("Site doesn`t found. Please wait a minute. Application try again");
            try {
                Thread.sleep(25000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            indexingSite();
        }
        assert document != null;
        Elements listData = document.select("div#bodyContent.vector-body");
        for (Element element : listData.select("p"))
            System.out.println(element.text());
        }

    public static void main(String[] args) throws InterruptedException {
        indexingSite();
    }
}

//#resulttable
//document.querySelector("#resulttable")
//