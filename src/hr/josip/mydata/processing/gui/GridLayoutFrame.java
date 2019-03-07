package hr.josip.mydata.processing.gui;

import hr.josip.mydata.processing.Date;
import hr.josip.mydata.processing.File;
import hr.josip.mydata.processing.PersonalId;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GridLayoutFrame extends JFrame implements ActionListener {
    private final Container container;
    private final GridLayout gridLayout;
    private final GridLayout gridLayout2;
    private final JButton[] buttons;
    private File file;
    private static final String[] names = {"Show all data", "Choose person","Insert new person","Copy data"};

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

        }else if(e.getActionCommand().equals(names[3])){
            JFileChooser jfc=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            JFileChooser jfc2=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue=jfc.showOpenDialog(null);
            int return2=jfc2.showOpenDialog(null);

            if(returnValue==JFileChooser.APPROVE_OPTION || return2==JFileChooser.APPROVE_OPTION){
                java.io.File selectedFile=jfc.getSelectedFile();
                java.io.File selectedFile2=jfc2.getSelectedFile();
                String copyFrom=selectedFile.getAbsolutePath();
                String copyTo=selectedFile2.getAbsolutePath();

                File file=new File();
                copyFrom=copyFrom.replace('\\','/');
                copyTo=copyTo.replace('\\','/');
                file.setAbsolute(copyFrom);
                File file2=new File();
                file2.setAbsolute(copyTo);
                File file3=new File();

                try {
                    file3.copyAbsoluteData(file,file2);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }






            }
        }

    }
}
