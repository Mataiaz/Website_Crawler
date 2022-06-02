package com.example;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class Input {
    public static void main(int rowNbr, String fileLocation) throws IOException {
        try {
            XSSFWorkbook wb = new XSSFWorkbook(fileLocation);
        XSSFSheet sheet = wb.getSheetAt(0);
        // evaluating cell type
        Row row = sheet.getRow(rowNbr);
        Cell cell = row.getCell(0);
        String domain = cell.toString();;
        wb.close();
        if (!domain.isEmpty())
        {
            //System.out.println("File was open and domain was retrived\n");
            Connect.main(domain, "");
        }
        domain.replace(" ", "");
        } catch (Exception e) {
            Error_Handler.main(e, "Input", "");
        }
    }
}
