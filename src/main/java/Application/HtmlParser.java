package Application;

import Data.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Application.XLSWritter.createDocument;

public class HtmlParser {

    public static void indexingSite(int numberOfSite) throws IOException {
        ArrayList<Product> productArrayList = new ArrayList<>();
        Document document = null;
        try {
            document = Jsoup.connect("https://coderoad.ru/16583701/").get();
        } catch (IOException e) {
            System.err.println("Site doesn`t found. Please wait a minute. Application try again");
            try {
                Thread.sleep(25000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            indexingSite(numberOfSite);
        }
        assert document != null;

        Elements listData = document.select("body");
        for (Element element: listData.select("a")) {
            System.out.println(element.text());
        }
        createDocument(productArrayList);
    }

    public static void main(String[] args) throws IOException {

        Scanner cin = new Scanner(System.in);
        System.out.println("Select url-site, which program must display in xml file\n1-\n2-\n3-\n4-");
        int num = cin.nextInt();

        indexingSite(num);
    }
}
