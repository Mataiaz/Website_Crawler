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
                "Do you want to run with a excel file?\n\n"
                        + "If you select NO the program will ask for 1 website",
                "Launcher", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.NO_OPTION) {
            try {
                App.userInputDomain = JOptionPane.showInputDialog(null, "Write in domain to check");
                App.fileLocation = null;
                Connect.main(App.userInputDomain, "");
                System.exit(0);
            } catch (Exception e) {
                Error_Handler.main(e, "GUI", App.userInputDomain);
            }
        }
        App.fileLocation = JOptionPane.showInputDialog(null, "What is the file called?", "exampleExcel");
        App.fileLocation += ".xlsx";
        String[] option = new String[3];
        option[0] = "Excel format (xlsx)";
        option[1] = "Text format (txt)";
        option[2] = "No format";

        Object selectedOption = JOptionPane.showInputDialog(null, "Choose a format to save in", "Format selection",
                JOptionPane.QUESTION_MESSAGE, null, option, "No format");
        System.out.println(selectedOption);

        response = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to run the program?\n\n" + "You have selected  " + selectedOption,
                "Launcher", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            try {
                Input_Info.main(App.rowNbr, App.fileLocation);
            } catch (Exception e) {
                Error_Handler.main(e, "GUI", App.userInputDomain);
            }
        }
        System.exit(0);
    }
}
