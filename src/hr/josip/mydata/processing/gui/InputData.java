package hr.josip.mydata.processing.gui;

import hr.josip.mydata.processing.Date;
import hr.josip.mydata.processing.PersonalId;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Calendar;


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
    private JComboBox dayecomboBox1;
    private JComboBox monthecomboBox1;
    private JComboBox yearecomboBox1;
    private JComboBox daybcomboBox1;
    private JComboBox monthbcomboBox1;
    private JComboBox yearbcomboBox1;
    private JComboBox dayicomboBox1;
    private JComboBox monthicomboBox1;
    private JComboBox yearicomboBox1;
    private JRadioButton sexMradioButton1;
    private JRadioButton sexFRadioButton;
    private ButtonGroup sex;
    private String sex1;

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

        sexFRadioButton=new JRadioButton("F");
        sexFRadioButton.setMnemonic('F');
        sexFRadioButton.setActionCommand("F");

        sexMradioButton1=new JRadioButton("M");
        sexMradioButton1.setMnemonic('M');
        sexFRadioButton.setActionCommand("M");

        sex=new ButtonGroup();
        sex.add(sexFRadioButton);
        sex.add(sexMradioButton1);

        return panel1;
    }


    public InputData() {

        saveDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonalId id=new PersonalId();
                id.setIdentityCardNumber(idTextField.getText());
                id.setDateOfExpiry(new Date((int) dayecomboBox1.getSelectedItem(),(int) monthecomboBox1.getSelectedItem(),
                        (int) yearecomboBox1.getSelectedItem()));
                id.setSurname(surname.getText());
                id.setName(name.getText());
                id.setSex(sex1.charAt(0));
                id.setCitizenship(citizenship.getText());
                id.setDateOfBirth(new Date(
                        (int) daybcomboBox1.getSelectedItem(),
                        (int) monthbcomboBox1.getSelectedItem(),
                        (int) yearbcomboBox1.getSelectedItem()
                ));
                id.setResidence(residence.getText());
                id.setIssuedBy(issuedby.getText());
                id.setDateOfIssue(new Date(
                        (int) dayicomboBox1.getSelectedItem(),
                        (int) monthicomboBox1.getSelectedItem(),
                        (int) yearicomboBox1.getSelectedItem()
                ));
                id.setPersonalIdentificationNumber(pin.getText());
                System.out.println(id);
                System.out.println(dayecomboBox1.getSelectedItem());


            }
        });

        sexMradioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sex1=sexMradioButton1.getText();

                System.out.println(sexMradioButton1.getText());
            }
        });
        sexFRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sex1=sexFRadioButton.getText();


                System.out.println(sexFRadioButton.getText());
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
