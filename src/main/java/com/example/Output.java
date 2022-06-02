package com.example;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;

public class Output {
    public static void main(int rowNbr, String fileLocation, String status) throws IOException, FileNotFoundException {
        try {
        XSSFWorkbook wb = new XSSFWorkbook(fileLocation);
        CellStyle cs = wb.createCellStyle();
        CreationHelper cellInput = wb.getCreationHelper();
        XSSFSheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(rowNbr);
        Cell cell = row.createCell(3);
        cell.setCellStyle(cs);
        cell.setCellValue(cellInput.createRichTextString(status));
        cs.setWrapText(true);
        wb.close();
        Thread.sleep(1000);
        App.rowNbr++;
        Input.main(App.rowNbr, App.fileLocation);
        } catch (Exception e) {
            Error_Handler.main(e, "Output", "");
        }
    }
}
