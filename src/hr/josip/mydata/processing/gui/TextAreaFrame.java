package hr.josip.mydata.processing.gui;

import hr.josip.mydata.processing.File;

import javax.swing.*;

public class TextAreaFrame extends JFrame {
    private final JTextArea textArea;

    //this function read data from file
    //and shows in  the new window
    //trough text area
    public TextAreaFrame(){

        super("List of objects in text file");
        Box box=Box.createHorizontalBox();
        File file=new File();
        String demo=file.readFromTextFile(file);
        textArea=new JTextArea(demo,10,15);
        box.add(new JScrollPane(textArea));

        add(box);
    }
}
