package hr.josip.mydata.processing.gui;

import hr.josip.mydata.processing.PersonalId;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayoutFrame extends JFrame implements ActionListener {
    private final Container container;
    private final GridLayout gridLayout;
    private final GridLayout gridLayout2;
    private final JButton[] buttons;
    private static final String[] names = {"Show all data", "Insert new person"};

    private boolean toogle = true;

    public GridLayoutFrame() {
        super("Main layout");
        gridLayout = new GridLayout(2, 3);
        gridLayout2=new GridLayout(11,0);

        container = getContentPane();
        setLayout(gridLayout);

        buttons = new JButton[names.length];

        addButtons();


    }
    public void addButtons(){
        for (int count = 0; count < names.length; count++) {
            buttons[count] = new JButton(names[count]);
            buttons[count].addActionListener(this);
            add(buttons[count]);
        }
    }
    public void removeButtons(){
        for (int count=0;count<names.length;count++){
            remove(buttons[count]);


        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(names[0])) {
            TextAreaFrame textAreaFrame = new TextAreaFrame();
            textAreaFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            textAreaFrame.setSize(1366, 768);
            textAreaFrame.setVisible(true);
        }else if(e.getActionCommand().equals(names[1])){
            setLayout(gridLayout2);
            container.validate();
            removeButtons();
            container.validate();
            PersonalId id=new PersonalId();
            id.setIdentityCardNumber(JOptionPane.showInputDialog("Enter identity card number:"));
            JOptionPane.showMessageDialog(null,id.getIdentityCardNumber()+"\t inserted successfully","Successfull insert",JOptionPane.PLAIN_MESSAGE);
            container.setLayout(gridLayout);
            addButtons();
            container.validate();
        }

    }
}
