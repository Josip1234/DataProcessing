package hr.josip.mydata.processing.gui;

import hr.josip.mydata.processing.File;
import hr.josip.mydata.processing.PersonalId;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ListFrame extends JFrame {
    private final JList<String> list;
    private String[] listOfNames=getNames();
    private PersonalId[] details;


    public  String[] getNames() throws IOException {

        File file=new File();
        ArrayList<PersonalId> personalIds=file.parseData(file);

        int index=0;
        String[] array=new String[personalIds.size()];
        details=new PersonalId[personalIds.size()];
        for (PersonalId id:personalIds) {
            array[index]=id.getName()+" "+id.getSurname();
            System.out.println(id.getDateOfExpiry());
            details[index]=id;
            index=index+1;
        }
       return  array;
    }


    public ListFrame() throws IOException {
        super("List of persons");
        File file=new File();
        list=new JList<String>(listOfNames);
        list.setVisibleRowCount(listOfNames.length);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list));

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting() == false) {

                    JFrame frame2 = new JFrame("Update Data");

                    frame2.setContentPane(new UpdateData(details, list.getSelectedIndex()).getPanel1());

                    frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame2.pack();
                    frame2.setVisible(true);

                    /*
                        TextAreaList textAreaFrame = new TextAreaList(details,list.getSelectedIndex());
                        textAreaFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        textAreaFrame.setSize(1366, 768);
                        textAreaFrame.setVisible(true);*/




                }


















            }
        });

    }

}
