package hr.josip.mydata.processing.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class InputData extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField idTextField;
    private JTextField surname;
    private JTextField name;
    private JTextField citizenship;
    private JTextField residence;
    private JTextField issuedby;
    private JTextField pin;
    private JButton saveDataButton;
    private JTextField textField3;
    private JComboBox dayecomboBox1;
    private JComboBox monthecomboBox1;
    private JComboBox yearecomboBox1;
    private JComboBox daybcomboBox1;
    private JComboBox monthbcomboBox1;
    private JComboBox yearbcomboBox1;
    private JComboBox dayicomboBox1;
    private JComboBox monthicomboBox1;
    private JComboBox yearicomboBox1;


    public JPanel getPanel1() {
        for (int i=1;i<=31;i++){
            dayecomboBox1.addItem(i);
            daybcomboBox1.addItem(i);
            dayicomboBox1.addItem(i);
        }
        for(int j=1;j<=12;j++){
            monthecomboBox1.addItem(j);
            monthbcomboBox1.addItem(j);
            monthicomboBox1.addItem(j);
        }

        int currentYear= Calendar.getInstance().get(Calendar.YEAR);
        for(int k=1900;k<=currentYear;k++ ){
            yearecomboBox1.addItem(k);
            yearbcomboBox1.addItem(k);
            yearicomboBox1.addItem(k);
        }

        return panel1;
    }


    public InputData() {

        saveDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(idTextField.getText());
                System.out.println(dayecomboBox1.getSelectedItem());
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
