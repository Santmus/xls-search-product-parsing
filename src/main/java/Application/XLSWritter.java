package Application;

import Data.Product;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XLSWritter {

    public static void createDocument() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Product");

        int rowNum = 0;

        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Ufc");
        row.createCell(1).setCellValue("Count");
        row.createCell(2).setCellValue("Price");

        FileOutputStream out = null;
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
