package com.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;

public class Output {
    public static void main(int rowNbr, String fileLocation, String domain, String status, String httpCodeFound, String scamOrSelling)
            throws IOException, FileNotFoundException, InterruptedException {
        try {
            FileOutputStream out = new FileOutputStream(fileLocation);
            XSSFWorkbook wb = new XSSFWorkbook();
            CellStyle cs = wb.createCellStyle();
            CreationHelper cellInput = wb.getCreationHelper();
            Sheet sheet = wb.createSheet("result");
            System.out.println(domain + status + httpCodeFound + scamOrSelling);
            Row row = sheet.createRow(rowNbr);
            Cell cell = row.createCell(0);
            cell.setCellStyle(cs);
            cell.setCellValue(cellInput.createRichTextString(domain));
            cell.setCellValue(domain);
            cs.setWrapText(true);
            cell = row.createCell(1);
            cell.setCellStyle(cs);
            cell.setCellValue(cellInput.createRichTextString(status));
            cell.setCellValue(status);
            cs.setWrapText(true);
            cell = row.createCell(2);
            cell.setCellStyle(cs);
            cell.setCellValue(cellInput.createRichTextString(httpCodeFound));
            cell.setCellValue(httpCodeFound);
            cs.setWrapText(true);
            cell = row.createCell(3);
            cell.setCellStyle(cs);
            cell.setCellValue(cellInput.createRichTextString(scamOrSelling));
            cell.setCellValue(scamOrSelling);
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            cs.setWrapText(true);
            wb.write(out);
            out.close();
            wb.close();
            Thread.sleep(1000);
            App.rowNbr++;
        } catch (Exception e) {
            Thread.sleep(1000);
            App.rowNbr++;
            Error_Handler.main(e, "Output", "");
        }
    }
}
