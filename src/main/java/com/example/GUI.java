package com.example;

import javax.swing.JOptionPane;

import java.io.IOException;

import javax.swing.JFrame;

public final class GUI extends JFrame {
    static int response;

    public static void main() throws InterruptedException, IOException {
        promtUser();
        // String note = "NOTE: Pressing the red x on the windows will not stop the
        // program, it will only hide the windows.";
        // JOptionPane.showMessageDialog(null, note);
        System.exit(0);
    }

    public static void promtUser() throws InterruptedException, IOException {
        response = JOptionPane.showConfirmDialog(null,
                "Are you planning on checking multiple websites?\n\n"
                        + "If you select NO the program will ask for 1 website",
                "Launcher", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.NO_OPTION) {
            try {
                String domain = JOptionPane.showInputDialog(null, "Write in a domain to check");
                if (domain.contains("www."))
                {
                    App.userInputDomain = domain.replace("www.", "");
                }
                App.fileLocation = null;
                Connect.main(App.userInputDomain, "");
                System.exit(0);
            } catch (Exception e) {
                Error_Handler.main(e, "GUI", App.userInputDomain);
            }
        }
        App.fileLocation = JOptionPane.showInputDialog(null, "What is the file called?", "exampleExcel");
        if (!App.fileLocation.contains(".xlsx"))
            {
                App.fileLocation += ".xlsx";
            }
        String[] option = new String[3];
        option[0] = "No format";
        option[1] = "Excel format (xlsx)";
        //option[2] = "Text format (txt)";

        Object selectedOption = JOptionPane.showInputDialog(null, "Choose a format to save in", "Format selection",
                JOptionPane.QUESTION_MESSAGE, null, option, "Excel format (xlsx)");
        System.out.println(selectedOption);
        if (selectedOption.toString() == option[1])
        {
            App.saveLocation = JOptionPane.showInputDialog(null, "What do you want to call the file?");
            if (!App.saveLocation.contains(".xlsx"))
            {
                App.saveLocation += ".xlsx";
            }
        }
        response = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to run the program?\n" + "You have selected  \"" + selectedOption + "\"",
                "Launcher", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            try {
                Create_File.main(App.saveLocation);
                Input_Info.main(App.rowNbr, App.fileLocation);
            } catch (Exception e) {
                Error_Handler.main(e, "GUI", App.userInputDomain);
            }
        }
        System.exit(0);
    }
}
