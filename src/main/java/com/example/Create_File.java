package com.example;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

public class Create_File {
    public static void main(String saveLocation) {
        try {
            FileOutputStream out = new FileOutputStream(saveLocation);
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("Result");
            CellStyle cs = wb.createCellStyle();
            CreationHelper cellInput = wb.getCreationHelper();
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellStyle(cs);
            cs.setVerticalAlignment(VerticalAlignment.CENTER);
            cs.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellValue(cellInput.createRichTextString("Domains"));
            cell = row.createCell(1);
            cell.setCellStyle(cs);
            cell.setCellValue(cellInput.createRichTextString("Status"));
            cell = row.createCell(2);
            cell.setCellStyle(cs);
            cell.setCellValue(cellInput.createRichTextString("Http code"));
            cell = row.createCell(3);
            cell.setCellStyle(cs);
            cell.setCellValue(cellInput.createRichTextString("Scam detection result"));
            wb.write(out);
            out.close();
            wb.close();
        } catch (Exception e) {
        }
    }
}
