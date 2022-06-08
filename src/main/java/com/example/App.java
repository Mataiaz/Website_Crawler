package com.example;
import java.io.IOException;
//Please read README.md before use!
public final class App {

    static int x = 0;

    //For multiple websites put in a excel file, use the exampleExcel.xlsx as a format.
    static String fileLocation = "";

    static String saveLocation = "resultExcel.xlsx";

    //For one website (for example github.com (remember to leave out the "https://"))
    static String userInputDomain = "";

    //This number is for how long the program will try to connect to a website,
    //it is recommended to be 10000millisecounds (10 sec)
    static int timeOut = 10000;

    //This number is for how many rows in the excel file you want to skip. It is set to 1 because if you look in exampleExcel.xlsx-
    //we have preset names at the top which is row 1 and we do not want to override it.
    static int rowNbr = 1;

    App() {
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("-------------------------------------------");
        GUI.main();
    }
}

/*
Workbook wb = new XSSFWorkbook();
                CellStyle cs = wb.createCellStyle();
                CreationHelper cellInput = wb.getCreationHelper();
                Sheet sheet = wb.createSheet("resultExcel");
                Row column = sheet.createRow(0);
                Cell cellPostDomain  = column.createCell(0);
                Cell cellPostStatus   = column.createCell(1);
                cellPostDomain.setCellValue(cellInput.createRichTextString("Domain"));
                cellPostStatus.setCellValue(cellInput.createRichTextString("Status"));
                cs.setWrapText(true);
                cellPostStatus.setCellStyle(cs);
                cellPostDomain.setCellStyle(cs);
                FileOutputStream out = new FileOutputStream(
                new File("resultExcel.xlsx"));
                wb.write(out);
                out.close();
                wb.close();
*/