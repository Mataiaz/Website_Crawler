package com.example;


import java.io.IOException;
/*

*/
public final class App {

    static int rowNbr = 1;
    static String fileLocation = "";

    private App() {
    }
    public static void main(String[] args) throws IOException {
        String domain = "en.wikipedia.org/wiki/Main_Page";
        if (!domain.isEmpty())
        {
            System.out.print("You are running with internal domain input\n");
            Connect.main(domain, "");
        }
        else
        {
            try {
                Input.main(App.rowNbr, fileLocation);
            } catch (Exception e) {
                Error_Handler.main(e, "App", domain);
            }
        }
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