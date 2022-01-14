package Application;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class TxtReader {

    public static void parsingSite(String nameOfSite, String nameArticle) {
        FileOutputStream fileOutputStream = FileCreator.createXLSFile(nameOfSite + ".xls");

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(nameArticle);

        String line = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("parser.txt"))) {
            {
                while ((line = bufferedReader.readLine()) != null) {
                    //System.out.println(line);
                    HtmlParser.indexingSite();
                }
                XLSWritter.createDocument(HtmlParser.productArrayList, "main-article", fileOutputStream, workbook, sheet);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parsingSite("site", "shop2.gzanders");
    }
}
