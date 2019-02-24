package hr.josip.mydata.processing;

import hr.josip.mydata.processing.gui.GridLayoutFrame;
import hr.josip.mydata.processing.gui.TextAreaFrame;

import javax.swing.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void writeData(File file,PersonalId[] ids){
        for (PersonalId idsa:ids) {
            file.writeToTextFile(idsa,file);
        }
        System.out.println("Successfully writen data!!!");
    }

    public static void enterValues(){
        boolean errors=false;
        File file=new File();
        file.makeDirectory(file);
        int unos=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("How much data you want to enter?");
        unos=scanner.nextInt();
        PersonalId[] id=file.enterValues(unos);



        //if there is any
        //dont write to file
        //call error
        //if everything is ok
        //write data
        //call successfull message
        //before writing to file check errors
        if((PersonalId.errors==true)||(Date.errors==true)){
            System.out.println("Data entry contains errors");

        }else{
            writeData(file,id);
            System.out.println("You have entered "+unos+" values.");
        }



    }
    //initialize main window with main grid layout
    //set close operations
    public static void swingMenu(){
        GridLayoutFrame gridLayoutFrame=new GridLayoutFrame();
        gridLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gridLayoutFrame.setSize(300,200);
        gridLayoutFrame.setVisible(true);
    }


    public static void main(String[] args) throws IOException {
            swingMenu();






    }
}