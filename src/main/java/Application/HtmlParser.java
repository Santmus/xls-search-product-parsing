package Application;

import Data.Product;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HtmlParser {
    public static final ArrayList<Product> productArrayList = new ArrayList<>();

    public static void indexingSite() throws IOException {
        Document document = null;
        String cost = null, ufc = null, value = null;
        try {
            document = Jsoup.connect("https://shop2.gzanders.com/optics-accessories-1.html?p=1&product_list_limit=50&product_list_order=position").get();
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

        Elements listData = document.select("#amasty-shopby-product-list");
        for (Element element: listData.select("li.item.product.product-item")) {
            System.out.println(element.text());
            Pattern pattern = Pattern.compile("\\$\\d.+");
            Matcher matcher = pattern.matcher(element.text());
            boolean found = matcher.find();
            if (found){
                cost = matcher.group();
                System.out.println(cost);
            }
            pattern = Pattern.compile("\\s\\d{12}");
            matcher = pattern.matcher(element.text());
            found = matcher.find();
            if (found){
                ufc = matcher.group();
                System.out.println(ufc);
            }
            pattern = Pattern.compile("Out of stock | In stock");
            matcher = pattern.matcher(element.text());
            found = matcher.find();
            if (found){
                value = matcher.group();
                System.out.println(value);
            }
            productArrayList.add(new Product(ufc, value, cost));
        }
    }
}
