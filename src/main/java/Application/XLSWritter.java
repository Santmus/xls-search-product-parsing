package Application;

import Data.Product;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class XLSWritter {

    public static int rowNum = 0;
    public static HSSFSheet sheet;

    public static void createDocument(ArrayList<Product> dataList) {

        HSSFWorkbook workbook = new HSSFWorkbook();
        sheet = workbook.createSheet("Product");

        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Ufc");
        row.createCell(1).setCellValue("Count");
        row.createCell(2).setCellValue("Price");

        for (Product dataModel : dataList) {
            addInfoToExcel(sheet, ++rowNum, dataModel);
        }

        FileOutputStream out;
        try {
            out = new FileOutputStream("result.xls");
            workbook.write(out);
        } catch (IOException e){
            System.err.println("File can`t create. Please wait a minute");
        }
        System.out.println("Excel file success create!");
    }

    public static void addInfoToExcel(HSSFSheet sheet, int rowNum, Product product) {
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue(product.getUfc());
        row.createCell(1).setCellValue(product.getCount());
        row.createCell(2).setCellValue(product.getPrice());
    }

}
