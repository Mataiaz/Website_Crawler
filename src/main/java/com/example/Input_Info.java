package com.example;

import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class Input_Info {
    static int totCases = 0;
    public static void main(int rowNbr, String fileLocation) throws IOException, InterruptedException {
            try {
                XSSFWorkbook wb = new XSSFWorkbook(fileLocation);
                XSSFSheet sheet = wb.getSheetAt(0);
                // evaluating cell type
                Row row = sheet.getRow(rowNbr);
                Cell cell = row.getCell(0);
                String domain = cell.toString();
                domain.replace(" ", "");
                wb.close();
                if (!domain.isEmpty()) {
                    rowNbr++;
                    Input_Info.totCases =+ rowNbr;
                    Input_Info.main(rowNbr, fileLocation);
                }
            } catch (Exception e) {
                Error_Handler.main(e, "Input_Info", "");
        }
        Input_Info.totCases -= 1;
        Load.main();
    }
}
