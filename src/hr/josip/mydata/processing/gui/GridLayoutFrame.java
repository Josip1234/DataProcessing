package hr.josip.mydata.processing.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayoutFrame extends JFrame implements ActionListener {
    private final Container container;
    private final GridLayout gridLayout;
    private final JButton button;
    public GridLayoutFrame(){
        super("Main layout");
        gridLayout=new GridLayout(2,3);
        container=getContentPane();
        button=new JButton("Show all data");
        button.setSize(100,100);
        button.addActionListener(this);
        add(button);
        setLayout(gridLayout);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TextAreaFrame textAreaFrame = new TextAreaFrame();
        textAreaFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        textAreaFrame.setSize(1366,768);
        textAreaFrame.setVisible(true);
    }
}
