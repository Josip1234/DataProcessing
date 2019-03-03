package hr.josip.mydata.processing.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputData extends JFrame {
    private JPanel panel1;
    private JTextField idTextField;
    private JTextField daye;
    private JTextField monthe;
    private JTextField yeare;
    private JTextField surname;
    private JTextField name;
    private JTextField sex;
    private JTextField citizenship;
    private JTextField dayb;
    private JTextField monthb;
    private JTextField yearb;
    private JTextField residence;
    private JTextField issuedby;
    private JTextField dayi;
    private JTextField monthi;
    private JTextField yeari;
    private JTextField pin;
    private JButton saveDataButton;

    public JPanel getPanel1() {
        return panel1;
    }

    public InputData() {
        saveDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }




}
