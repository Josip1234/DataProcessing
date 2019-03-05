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

                if(idTextField.getText().length()==0){
                    JOptionPane.showMessageDialog(null,"Input cannot be null.","Null input",JOptionPane.ERROR_MESSAGE);

                }else if(idTextField.getText().length()<9){
                    JOptionPane.showMessageDialog(null,"Input must have more or equal 9 characters.","Length error",JOptionPane.ERROR_MESSAGE);
                }else if(id.checkStringValue(idTextField.getText())){
                   JOptionPane.showMessageDialog(null,"Input is not a number!","Format number error",JOptionPane.ERROR_MESSAGE);
                }else{
                    id.setIdentityCardNumber(idTextField.getText());
                }

                if(new Date((int) dayecomboBox1.getSelectedItem(),(int) monthecomboBox1.getSelectedItem(),
                        (int) yearecomboBox1.getSelectedItem()).validateDate((int) dayecomboBox1.getSelectedItem(),(int) monthecomboBox1.getSelectedItem(),
                        (int) yearecomboBox1.getSelectedItem())){
                    JOptionPane.showMessageDialog(null,"Invalid date for that year!","Date errror",JOptionPane.ERROR_MESSAGE);
                }else{
                    id.setDateOfExpiry(new Date((int) dayecomboBox1.getSelectedItem(),(int) monthecomboBox1.getSelectedItem(),
                            (int) yearecomboBox1.getSelectedItem()));
                }


                if(surname.getText().length()==0){
                    JOptionPane.showMessageDialog(null,"Input cannot be null.","Null input",JOptionPane.ERROR_MESSAGE);
                }else if(surname.getText().length()>50){
                    JOptionPane.showMessageDialog(null,"Input must have less or equals than 50 characters.","Length error",JOptionPane.ERROR_MESSAGE);
                }else{
                    id.setSurname(surname.getText());
                }
                if(name.getText().length()==0){
                    JOptionPane.showMessageDialog(null,"Input cannot be null.","Null input",JOptionPane.ERROR_MESSAGE);
                }else if(name.getText().length()>50){
                    JOptionPane.showMessageDialog(null,"Input must have less or equals than 50 characters.","Length error",JOptionPane.ERROR_MESSAGE);
                }else{
                    id.setName(name.getText());
                }
                id.setSex(sex1.charAt(0));
                if(citizenship.getText().length()==0){
                    JOptionPane.showMessageDialog(null,"Input cannot be null.","Null input",JOptionPane.ERROR_MESSAGE);
                }else if(citizenship.getText().length()>20){
                    JOptionPane.showMessageDialog(null,"Input must have less or equals than 20 characters.","Length error",JOptionPane.ERROR_MESSAGE);
                }else{
                    id.setCitizenship(citizenship.getText());
                }

                if(new Date((int) daybcomboBox1.getSelectedItem(),(int) monthbcomboBox1.getSelectedItem(),
                        (int) yearbcomboBox1.getSelectedItem()).validateDate((int) daybcomboBox1.getSelectedItem(),(int) monthbcomboBox1.getSelectedItem(),
                        (int) yearbcomboBox1.getSelectedItem())){
                    JOptionPane.showMessageDialog(null,"Invalid date for that year!","Date errror",JOptionPane.ERROR_MESSAGE);
                }else{
                    id.setDateOfBirth(new Date(
                            (int) daybcomboBox1.getSelectedItem(),
                            (int) monthbcomboBox1.getSelectedItem(),
                            (int) yearbcomboBox1.getSelectedItem()
                    ));
                }



                if(residence.getText().length()==0){
                    JOptionPane.showMessageDialog(null,"Input cannot be null.","Null input",JOptionPane.ERROR_MESSAGE);
                }else if(residence.getText().length()>100){
                    JOptionPane.showMessageDialog(null,"Input must have less or equals than 100 characters.","Length error",JOptionPane.ERROR_MESSAGE);
                }else if(!id.doesStringHaveOneComa(residence.getText())){
                    JOptionPane.showMessageDialog(null,"This entry must have at least 1 coma and word after comma","Comma error",JOptionPane.ERROR_MESSAGE);
                }else{
                    id.setResidence(residence.getText());
                }

                if(issuedby.getText().length()==0){
                    JOptionPane.showMessageDialog(null,"Input cannot be null.","Null input",JOptionPane.ERROR_MESSAGE);
                }else if(issuedby.getText().length()>150){
                    JOptionPane.showMessageDialog(null,"Input must have less or equals than 150 characters.","Length error",JOptionPane.ERROR_MESSAGE);
                }else{
                    id.setIssuedBy(issuedby.getText());
                }


                if(new Date((int) dayicomboBox1.getSelectedItem(),(int) monthicomboBox1.getSelectedItem(),
                        (int) yearicomboBox1.getSelectedItem()).validateDate((int) dayicomboBox1.getSelectedItem(),(int) monthicomboBox1.getSelectedItem(),
                        (int) yearicomboBox1.getSelectedItem())){
                    JOptionPane.showMessageDialog(null,"Invalid date for that year!","Date errror",JOptionPane.ERROR_MESSAGE);
                }else{
                    id.setDateOfIssue(new Date(
                            (int) dayicomboBox1.getSelectedItem(),
                            (int) monthicomboBox1.getSelectedItem(),
                            (int) yearicomboBox1.getSelectedItem()
                    ));
                }



                if(pin.getText().length()==0){
                    JOptionPane.showMessageDialog(null,"Input cannot be null.","Null input",JOptionPane.ERROR_MESSAGE);
                }else if(pin.getText().length()<11){
                    JOptionPane.showMessageDialog(null,"Input must have more or equal than 11 characters.","Length error",JOptionPane.ERROR_MESSAGE);
                }else if(id.checkStringValue(pin.getText())){
                    JOptionPane.showMessageDialog(null,"Input is not a number!","Format number error",JOptionPane.ERROR_MESSAGE);
                }else{
                    id.setPersonalIdentificationNumber(pin.getText());
                }




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
