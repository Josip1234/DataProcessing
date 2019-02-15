package hr.josip.mydata.processing;

import java.util.Scanner;

public class Main {

    public static void writeData(File file,PersonalId[] ids){
        for (PersonalId idsa:ids) {
            file.writeToTextFile(idsa,file);
        }
        System.out.println("Successfully writen data!!!");
    }

    public static void enterValues(){
        File file=new File();
        file.makeDirectory(file);
        int unos=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("How much data you want to enter?");
        unos=scanner.nextInt();
        PersonalId[] id=file.enterValues(unos);
        writeData(file,id);
        System.out.println("You have entered "+unos+" values.");

    }


    public static void main(String[] args) {







    }
}
