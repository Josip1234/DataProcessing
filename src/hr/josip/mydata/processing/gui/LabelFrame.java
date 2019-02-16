package hr.josip.mydata.processing.gui;

import hr.josip.mydata.processing.File;

import javax.swing.*;
import java.awt.*;

public class LabelFrame extends JFrame {
    private final JLabel label1;

    public LabelFrame(){
        super("Personal data");
        setLayout(new FlowLayout());

        File file = new File();
        label1=new JLabel(file.readFromFile(file,1));

        add(label1);

    }
}
