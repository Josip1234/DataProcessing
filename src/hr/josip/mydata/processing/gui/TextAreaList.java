package hr.josip.mydata.processing.gui;

import hr.josip.mydata.processing.File;
import hr.josip.mydata.processing.PersonalId;

import javax.swing.*;

public class TextAreaList extends JFrame {
    private final JTextArea textArea2;

    public TextAreaList(PersonalId[] polje,int index){

        super("List of person details");
        Box box=Box.createHorizontalBox();


        textArea2=new JTextArea(polje[index].toString(),10,15);

        box.add(new JScrollPane(textArea2));

        add(box);
    }

}
