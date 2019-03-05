package hr.josip.mydata.processing.gui;

import hr.josip.mydata.processing.Date;
import hr.josip.mydata.processing.File;
import hr.josip.mydata.processing.PersonalId;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GridLayoutFrame extends JFrame implements ActionListener {
    private final Container container;
    private final GridLayout gridLayout;
    private final GridLayout gridLayout2;
    private final JButton[] buttons;

    private static final String[] names = {"Show all data", "Choose person","Insert new person"};

    private boolean toogle = true;

    /**
     * Main grid layout frame
     */
    public GridLayoutFrame() {
        super("Main layout");
        gridLayout = new GridLayout(2, 3);
        gridLayout2=new GridLayout(11,11);

        container = getContentPane();
        setLayout(gridLayout);

        buttons = new JButton[names.length];

        addButtons();


    }

    /**
     * add button menu into the main grid layout
     */
    public void addButtons(){
        for (int count = 0; count < names.length; count++) {
            buttons[count] = new JButton(names[count]);
            buttons[count].addActionListener(this);
            add(buttons[count]);
        }
    }
    //remove buttons from grid layout
    public void removeButtons(){
        for (int count=0;count<names.length;count++){
            remove(buttons[count]);


        }
    }

    //new area frame after button is clicked
    //it will show all the data in the new window
    public void showData(){
        TextAreaFrame textAreaFrame = new TextAreaFrame();
        textAreaFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        textAreaFrame.setSize(1366, 768);

        textAreaFrame.setVisible(true);
    }

    //after button is clicked, call this function
    //if button name equals action command name
    //show all data
    //else
    //input data
    //while inputing data
    //remove all from main grid layout
    //insert data
    //brng back buttons to main layout
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(names[0])) {
            showData();
        }else if(e.getActionCommand().equals(names[1])){

            ListFrame listFrame= null;
            try {
                listFrame = new ListFrame();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            listFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            listFrame.setSize(350,150);
            listFrame.setVisible(true);

        }else if(e.getActionCommand().equals(names[2])){

            JFrame frame = new JFrame("InputData");
            frame.setContentPane(new InputData().getPanel1());

            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);











        }

    }
}
