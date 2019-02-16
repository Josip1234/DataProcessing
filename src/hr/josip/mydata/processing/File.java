package hr.josip.mydata.processing;

import java.io.*;
import java.util.Scanner;

public class File implements FileOperations {
    private String directory;
    private String separateBy;
    private String fileName;
    private String extension;

    public File(String directory,  String fileName, String extension) {
        this.directory = directory;
        this.separateBy = "/";
        this.fileName = fileName;
        this.extension = extension;
    }

    public File() {
        this.directory="personalDirectory";
        this.separateBy="/";
        this.fileName="personalIdData";
        this.extension=".dat";
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getSeparateBy() {
        return separateBy;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
    public String getFullFileName(){
        return getDirectory()+getSeparateBy()+getFileName()+getExtension();
    }

    @Override
    public void makeDirectory(File fil) {
        java.io.File file = new java.io.File(fil.getDirectory());
        if(file.exists()){
            System.out.println("Directory already exists.Please, give another name.");
        }else{
            file.mkdir();
        }


    }

    @Override
    public void deleteDirectory(File fil) {
        java.io.File file=new java.io.File(fil.getDirectory());
        if(file.exists()){
            file.delete();
            System.out.println("Directory has been deleted.");
        }else{
            System.out.println("Cannot delete directory because it does not exists.");
        }
    }

    @Override
    public void printDirectory(File fil) {
        java.io.File file= null;
        String[] paths;
        try {
            file=new java.io.File(fil.getDirectory());
            paths=file.list();
            for (String path:paths){
                System.out.println(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void writeToTextFile(Object o, File file) {
        if(o instanceof PersonalId){
            try {
                PrintWriter printWriter=new PrintWriter(new FileOutputStream(file.getFullFileName(),true));
                printWriter.println(o);
                printWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void readFromFile(File file, int number) {
        Scanner inputStream=null;
        try {
            inputStream=new Scanner(new FileInputStream(file.getFullFileName()));

            for (int i=0;i<number;i++){

                  if(inputStream.hasNextLine()){
                      System.out.println(inputStream.nextLine());
                  }else {
                      System.out.println("There is no data in this file anymore.");
                      break;
                  }




            }
            inputStream.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }


    @Override
    public void readFromTextFile(File file) {
        Scanner inputStream=null;
        try {
            inputStream=new Scanner(new FileInputStream(file.getFullFileName()));
            while (inputStream.hasNextLine()){
                System.out.println(inputStream.nextLine());
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteFile(File fil) {
        java.io.File file = new java.io.File(fil.getDirectory()+fil.getSeparateBy()+fil.getFileName()+fil.getExtension());
        if(file.exists()){
            file.delete();
            System.out.println("File has been erased.");
        }else{
            System.out.println("File does not exists");
        }


    }

    @Override
    public String toString() {
        return "File{" +
                "directory='" + directory + '\'' +
                ", separateBy='" + separateBy + '\'' +
                ", fileName='" + fileName + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }

    @Override
    public PersonalId[] enterValues(int number) {
        PersonalId[] ids=new PersonalId[number];
        Scanner scanner=new Scanner(System.in);
        PersonalId id=new PersonalId();
        for (int i=0;i<number;i++){
            System.out.println("Enter identity card number:");
            id.setIdentityCardNumber(scanner.nextLine());
            System.out.println("Enter date of expire:");
            System.out.println("Enter day:");
            int day=scanner.nextInt();
            System.out.println("Enter month");
            int month=scanner.nextInt();
            System.out.println("Enter year:");
            int year=scanner.nextInt();
            id.setDateOfExpiry(new Date(day,month,year));
            scanner.nextLine();
            System.out.println("Enter surname:");
            String surname=scanner.nextLine();
            id.setSurname(surname);
            System.out.println("Enter name:");
            id.setName(scanner.nextLine());
            System.out.println("Enter sex:");
            id.setSex(scanner.nextLine().charAt(0));
            System.out.println("Enter citizenship:");
            id.setCitizenship(scanner.nextLine());
            System.out.println("Enter date of birth:");
            System.out.println("Enter day:");
            day=scanner.nextInt();
            System.out.println("Enter month");
            month=scanner.nextInt();
            System.out.println("Enter year:");
            year=scanner.nextInt();
            id.setDateOfBirth(new Date(day,month,year));
            scanner.nextLine();
            System.out.println("Enter residence:");
            id.setResidence(scanner.nextLine());
            System.out.println("Enter issued by:");
            id.setIssuedBy(scanner.nextLine());
            System.out.println("Enter date of issue:");
            System.out.println("Enter day:");
            day=scanner.nextInt();
            System.out.println("Enter month");
            month=scanner.nextInt();
            System.out.println("Enter year:");
            year=scanner.nextInt();
            id.setDateOfIssue(new Date(day,month,year));
            scanner.nextLine();
            System.out.println("Enter personal identification number:");
            id.setPersonalIdentificationNumber(scanner.nextLine());
            ids[i]=new PersonalId(id.getIdentityCardNumber(),id.getDateOfExpiry(),id.getSurname(),id.getName(),id.getSex(),id.getCitizenship(),id.getDateOfBirth(),id.getResidence(),id.getIssuedBy(),id.getDateOfIssue(),id.getPersonalIdentificationNumber());

        }
        return ids;
    }
}
