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

    private static final String[] names = {"Show all data", "Insert new person","Choose person","Forms"};

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
    //simple data input
    public void insertData(){
        PersonalId id=new PersonalId();
        File file=new File();
        id.setIdentityCardNumber(JOptionPane.showInputDialog("Enter identity card number:"));
        String day=JOptionPane.showInputDialog("Enter day of expiry:");
        int dayOfExpire=Integer.parseInt(day);
        String month=JOptionPane.showInputDialog("Enter month of expire:");
        int monthOfExpire=Integer.parseInt(month);
        String year=JOptionPane.showInputDialog("Enter year of expire:");
        int yearOfExpire=Integer.parseInt(year);
        Date date=new Date(dayOfExpire,monthOfExpire,yearOfExpire);
        id.setDateOfExpiry(date);
        id.setSurname(JOptionPane.showInputDialog("Enter surname:"));
        id.setName(JOptionPane.showInputDialog("Enter first name:"));
        id.setSex(JOptionPane.showInputDialog("Enter sex:").charAt(0));
        id.setCitizenship(JOptionPane.showInputDialog("Enter citizenship:"));
        String dayOFBirth=JOptionPane.showInputDialog("Enter day of birth:");
        String monthOfBirth=JOptionPane.showInputDialog("Enter month of birth:");
        String yearOfBirth=JOptionPane.showInputDialog("Enter year of birth:");
        int dayOfBBirth=Integer.parseInt(dayOFBirth);
        int monthOFBirth=Integer.parseInt(monthOfBirth);
        int yearOFBirth=Integer.parseInt(yearOfBirth);
        date=new Date(dayOfBBirth,monthOFBirth,yearOFBirth);
        id.setDateOfBirth(date);
        id.setResidence(JOptionPane.showInputDialog("Enter residence:"));
        id.setIssuedBy(JOptionPane.showInputDialog("Enter issued by:"));
        String dayOfIssue=JOptionPane.showInputDialog("Enter day of issue:");
        String monthOfIssue=JOptionPane.showInputDialog("Enter month of issue:");
        String yearOfIssue=JOptionPane.showInputDialog("Enter year of issue:");
        int dayOFIssue=Integer.parseInt(dayOfIssue);
        int monthOFIssue=Integer.parseInt(monthOfIssue);
        int yearOFIssue=Integer.parseInt(yearOfIssue);
        date=new Date(dayOFIssue,monthOFIssue,yearOFIssue);
        id.setDateOfIssue(date);
        id.setPersonalIdentificationNumber(JOptionPane.showInputDialog("Enter personal identification number"));
        JOptionPane.showMessageDialog(null,"Data entered successfuly","Successfull insert",JOptionPane.PLAIN_MESSAGE);
        file.writeToTextFile(id,file);
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
            setLayout(gridLayout2);
            container.validate();
            removeButtons();
            container.validate();
            insertData();
            container.setLayout(gridLayout);
            addButtons();
            container.validate();
        }else if(e.getActionCommand().equals(names[2])){

            ListFrame listFrame= null;
            try {
                listFrame = new ListFrame();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            listFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            listFrame.setSize(350,150);
            listFrame.setVisible(true);

        }else if(e.getActionCommand().equals(names[3])){
            container.validate();
            removeButtons();
            container.validate();







            lblNamme=new JLabel("Insert day of expire:");
            add(lblNamme);

            JTextField day=new JTextField(2);
            add(day);

            lblNamme=new JLabel("Insert month of expire:");
            add(lblNamme);

            JTextField month=new JTextField(2);
            add(month);

            lblNamme=new JLabel("Insert year of expire:");
            add(lblNamme);

            JTextField year=new JTextField(4);
            add(year);

            lblNamme=new JLabel("Insert surname:");
            add(lblNamme);

            JTextField surname=new JTextField(15);
            add(surname);

            lblNamme=new JLabel("Insert name:");
            add(lblNamme);

            JTextField name=new JTextField(15);
            add(name);

            lblNamme=new JLabel("Insert sex:");
            add(lblNamme);

            JTextField sex=new JTextField(1);
            add(sex);

            lblNamme=new JLabel("Insert citizenship:");
            add(lblNamme);

            JTextField citizenship=new JTextField(15);
            add(citizenship);


            lblNamme=new JLabel("Insert day of birth:");
            add(lblNamme);

            JTextField dayb=new JTextField(2);
            add(dayb);

            lblNamme=new JLabel("Insert month of birth:");
            add(lblNamme);

            JTextField monthb=new JTextField(2);
            add(monthb);

            lblNamme=new JLabel("Insert year of birth:");
            add(lblNamme);

            JTextField yearb=new JTextField(4);
            add(yearb);

            lblNamme=new JLabel("Enter residence:");
            add(lblNamme);

            JTextField residence=new JTextField(15);
            add(residence);

            lblNamme=new JLabel("Insert Issued by:");
            add(lblNamme);

            JTextField issuedby=new JTextField(15);
            add(issuedby);


            lblNamme=new JLabel("Insert day of issue:");
            add(lblNamme);

            JTextField dayi=new JTextField(2);
            add(dayi);

            lblNamme=new JLabel("Insert month of issue:");
            add(lblNamme);

            JTextField monthi=new JTextField(2);
            add(monthi);

            lblNamme=new JLabel("Insert year of issue:");
            add(lblNamme);

            JTextField yeari=new JTextField(2);
            add(yeari);

            lblNamme=new JLabel("Insert PIN:");
            add(lblNamme);

            JTextField pin=new JTextField(15);
            add(pin);

            JButton button=new JButton("Submit form");
            add(button);













        }

    }
}
