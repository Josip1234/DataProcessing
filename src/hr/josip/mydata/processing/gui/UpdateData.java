package hr.josip.mydata.processing.gui;

import hr.josip.mydata.processing.Date;
import hr.josip.mydata.processing.File;
import hr.josip.mydata.processing.PersonalId;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;

public class UpdateData extends JFrame implements ActionListener {
    private JComboBox dayecomboBox1;
    private JComboBox monthecomboBox2;
    private JComboBox yearecomboBox3;
    private JTextField surname;
    private JTextField Name;
    private JTextField citizenship;
    private JTextField residence;
    private JTextField issuedBy;
    private JComboBox dayicomboBox1;
    private JComboBox monthicomboBox1;
    private JComboBox yearicomboBox1;
    private JButton UpdateData;
    private JPanel panel1;
    private JButton Delete;


    public JPanel getPanel1() {

        for (int i=1;i<=31;i++){
            dayecomboBox1.addItem(i);
            dayicomboBox1.addItem(i);

        }
        for(int j=1;j<=12;j++){
            monthecomboBox2.addItem(j);
            monthicomboBox1.addItem(j);

        }

        int currentYear= Calendar.getInstance().get(Calendar.YEAR);
        for(int k=1900;k<=currentYear;k++ ){
            yearecomboBox3.addItem(k);
            yearicomboBox1.addItem(k);

        }



        return panel1;
    }
    public UpdateData(PersonalId[] polje,int index){
        PersonalId id=new PersonalId();
        id.setIdentityCardNumber(polje[index].getIdentityCardNumber());
        System.out.println(polje[index].getDateOfExpiry());
        dayecomboBox1.setSelectedItem(polje[index].getDateOfExpiry().getDay());
        monthecomboBox2.setSelectedItem(polje[index].getDateOfExpiry().getMonth());
        yearecomboBox3.setSelectedItem(polje[index].getDateOfExpiry().getYear());
        surname.setText(polje[index].getSurname());
        Name.setText(polje[index].getName());
        id.setSex(polje[index].getSex());
        citizenship.setText(polje[index].getCitizenship());
        id.setDateOfBirth(polje[index].getDateOfBirth());
        residence.setText(polje[index].getResidence());
        issuedBy.setText(polje[index].getIssuedBy());
        dayicomboBox1.setSelectedItem(polje[index].getDateOfIssue().getDay());
        monthicomboBox1.setSelectedItem(polje[index].getDateOfIssue().getMonth());
        yearicomboBox1.setSelectedItem(polje[index].getDateOfIssue().getYear());
        id.setPersonalIdentificationNumber(polje[index].getPersonalIdentificationNumber());

        UpdateData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(id.getIdentityCardNumber());

                id.setDateOfExpiry(new Date((int)dayecomboBox1.getSelectedItem(),(int)monthecomboBox2.getSelectedItem(),
                        (int)yearecomboBox3.getSelectedItem()));

                id.setSurname(surname.getText());
                id.setName(Name.getText());
                id.setCitizenship(citizenship.getText());
                id.setResidence(residence.getText());
                id.setIssuedBy(issuedBy.getText());
                id.setDateOfIssue(new Date(
                        (int) dayicomboBox1.getSelectedItem(),
                        (int) monthicomboBox1.getSelectedItem(),
                        (int) yearicomboBox1.getSelectedItem()
                ));
                System.out.println(id);
                File file=new File();
                try {
                    file.updateData(id.getIdentityCardNumber(),id,file);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file=new File();
                try {
                    file.deleteData(id.getIdentityCardNumber(),file);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
