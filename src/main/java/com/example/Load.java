package com.example;

import java.io.IOException;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

/**
 * Hello world!
 */
public final class Load extends JFrame {
    static JProgressBar progressBar;

    Load() throws MalformedURLException, InterruptedException {
        progressBar = new JProgressBar(App.rowNbr, Input_Info.totCases);
        if (Input_Info.totCases < 2) {
            progressBar.setIndeterminate(true);
        }
        progressBar.setBounds(40, 40, 160, 30);
        progressBar.setValue(App.rowNbr);
        progressBar.setStringPainted(true);
        add(progressBar);
        setLocationRelativeTo(null);

        setSize(250, 150);
        setLayout(null);
    }

    public static void main() throws InterruptedException, IOException {
        if (App.rowNbr <= 1) {
            Load loadObject = new Load();
            loadObject.setVisible(true);
            loadObject.loadTest();
        } else {
            progressBar.setValue(App.rowNbr);
        }
    }

    public void loadTest() throws IOException, InterruptedException {
        while (App.rowNbr < Input_Info.totCases && App.rowNbr != Input_Info.totCases) {
            try {
                progressBar.setValue(App.rowNbr);
            } catch (Exception e) {
                System.exit(0);
                System.out.println(e);
            }
            Input.main(App.rowNbr, App.fileLocation);
        }
        progressBar.setValue(App.rowNbr);
        Input.main(App.rowNbr, App.fileLocation);
        System.out.println("Finished!");
        Thread.sleep(150);
        System.exit(0);
    }
}
