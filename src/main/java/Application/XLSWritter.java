package Application;

import Data.Product;
import lombok.SneakyThrows;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class XLSWritter {

    public static int rowNum = 0;

    @SneakyThrows
    public static void createDocument(ArrayList<Product> dataList, String nameArticle, FileOutputStream outputStream, HSSFWorkbook workbook, HSSFSheet sheet) {

        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Ufc");
        row.createCell(1).setCellValue("Count");
        row.createCell(2).setCellValue("Price");

        for (Product dataModel : dataList) {
            addInfoToExcel(sheet, ++rowNum, dataModel);
        }
        workbook.write(outputStream);
    }

    public static void addInfoToExcel(HSSFSheet sheet, int rowNum, Product product) {
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue(product.getUfc());
        row.createCell(1).setCellValue(product.getCount());
        row.createCell(2).setCellValue(product.getPrice());
    }

}
