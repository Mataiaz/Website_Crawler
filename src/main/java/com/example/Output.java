package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

public class Output {
    public static void main(int rowNbr, String saveLocation, String domain, String status, String httpCodeFound, String scamOrSelling)
            throws IOException, FileNotFoundException, InterruptedException {
        try {
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(saveLocation));
            //OutputStream out = new FileOutputStream(saveLocation);
            CellStyle cs = wb.createCellStyle();
            CreationHelper cellInput = wb.getCreationHelper();
            XSSFSheet sheet = wb.getSheet("Result");
            System.out.println(domain + status + httpCodeFound + scamOrSelling);
            System.out.println(rowNbr);
            Row row = sheet.createRow(rowNbr);
            System.out.println("wwewewewe");
            Cell cell = row.createCell(0);
            cell.setCellStyle(cs);
            cs.setVerticalAlignment(VerticalAlignment.CENTER);
            cs.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellValue(cellInput.createRichTextString(domain));
            //cell.setCellValue(domain);
            cell = row.createCell(1);
            cell.setCellStyle(cs);
            cell.setCellValue(cellInput.createRichTextString(status));
            cell = row.createCell(2);
            cell.setCellStyle(cs);
            cell.setCellValue(cellInput.createRichTextString(httpCodeFound));
            cell = row.createCell(3);
            cell.setCellStyle(cs);
            cell.setCellValue(cellInput.createRichTextString(scamOrSelling));
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            FileOutputStream out = new FileOutputStream(saveLocation);
            wb.write(out);
            out.close();
            wb.close();
            App.rowNbr++;
        } catch (Exception e) {
            System.out.println(e);
            Thread.sleep(1000);
            App.rowNbr++;
            Error_Handler.main(e, "Output", "");
        }
    }
}
