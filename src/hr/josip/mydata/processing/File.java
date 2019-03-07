package hr.josip.mydata.processing;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class File implements FileOperations {
    private String directory;
    private String separateBy;
    private String fileName;
    private String extension;
    private static String systemProperty=System.getProperty("user.name");
    private String absolute;

    public File(String absolute) {
        this.absolute = absolute;
    }

    @Override
    public String readAbsolute(File file) throws IOException {
        Scanner inputStream=null;
        String data="";
        try {
            inputStream=new Scanner(new FileInputStream(file.getAbsolute()));
            while (inputStream.hasNextLine()){
                data+=inputStream.nextLine()+"\n";

            }
            inputStream.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        return data;
    }

    public String getAbsolute() {
        return absolute;
    }

    public void setAbsolute(String absolute) {
        this.absolute = absolute;
    }

    public void setSeparateBy(String separateBy) {
        this.separateBy = separateBy;
    }

    public static void setSystemProperty(String systemProperty) {
        File.systemProperty = systemProperty;
    }


    public static String getSystemProperty() {
        return systemProperty;
    }


    @Override
    public ArrayList<PersonalId> parseDataAbsolute(File file) throws IOException {
        ArrayList<PersonalId> id=new ArrayList<PersonalId>();
        PersonalId personalId=new PersonalId();
        Scanner input=new Scanner(new FileInputStream(file.getAbsolute()));
        input.useDelimiter(","); //delimitor is one or more spaces

        try {
            while(input.hasNext()){

                personalId.setIdentityCardNumber(input.next().trim());
                personalId.setDateOfExpiry(Date.parseDate(input.next()));
                personalId.setSurname(input.next());
                personalId.setName(input.next());
                personalId.setSex(input.next().charAt(0));
                personalId.setCitizenship(input.next());
                personalId.setDateOfBirth(Date.parseDate(input.next()));
                personalId.setResidence(input.next()+","+input.next());
                personalId.setIssuedBy(input.next());
                personalId.setDateOfIssue(Date.parseDate(input.next()));
                personalId.setPersonalIdentificationNumber(input.next());

                id.add(personalId);
                personalId=new PersonalId();






            }
        } catch (Exception e) {

        }
        input.close();



        return id;
    }

    @Override
    public ArrayList<PersonalId> parseData(File file) throws IOException {
        ArrayList<PersonalId> id=new ArrayList<PersonalId>();
        PersonalId personalId=new PersonalId();
        Scanner input=new Scanner(new FileInputStream(file.getFullFileName()));
        input.useDelimiter(","); //delimitor is one or more spaces

        try {
            while(input.hasNext()){

                personalId.setIdentityCardNumber(input.next().trim());
                personalId.setDateOfExpiry(Date.parseDate(input.next()));
                personalId.setSurname(input.next());
                personalId.setName(input.next());
                personalId.setSex(input.next().charAt(0));
                personalId.setCitizenship(input.next());
                personalId.setDateOfBirth(Date.parseDate(input.next()));
                personalId.setResidence(input.next()+","+input.next());
                personalId.setIssuedBy(input.next());
                personalId.setDateOfIssue(Date.parseDate(input.next()));
                personalId.setPersonalIdentificationNumber(input.next());

                id.add(personalId);
                personalId=new PersonalId();






            }
        } catch (Exception e) {

        }
        input.close();



        return id;
    }

    @Override
    public boolean findItem(String numberId,File files)  {
        PersonalId ids=new PersonalId();
        boolean found=false;
        try {
            ArrayList<PersonalId> list=parseData(files);
            for (PersonalId id:list) {
                if(numberId.equals(id.getIdentityCardNumber())){
                    ids.setPersonalIdentificationNumber(id.getPersonalIdentificationNumber());
                    ids.setDateOfIssue(id.getDateOfIssue());
                    ids.setIssuedBy(id.getIssuedBy());
                    ids.setResidence(id.getResidence());
                    ids.setDateOfBirth(id.getDateOfBirth());
                    ids.setCitizenship(id.getCitizenship());
                    ids.setSex(id.getSex());
                    ids.setName(id.getName());
                    ids.setSurname(id.getSurname());
                    ids.setIdentityCardNumber(id.getIdentityCardNumber());
                    ids.setDateOfExpiry(id.getDateOfExpiry());
                    found=true;
                    break;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return found;
    }

    @Override
    public PersonalId findObject(String numberId,File files)  {
        PersonalId ids=new PersonalId();
        boolean found=false;
        try {
            ArrayList<PersonalId> list=parseData(files);
            for (PersonalId id:list) {
                if(numberId.equals(id.getIdentityCardNumber())){
                    ids.setPersonalIdentificationNumber(id.getPersonalIdentificationNumber());
                    ids.setDateOfIssue(id.getDateOfIssue());
                    ids.setIssuedBy(id.getIssuedBy());
                    ids.setResidence(id.getResidence());
                    ids.setDateOfBirth(id.getDateOfBirth());
                    ids.setCitizenship(id.getCitizenship());
                    ids.setSex(id.getSex());
                    ids.setName(id.getName());
                    ids.setSurname(id.getSurname());
                    ids.setIdentityCardNumber(id.getIdentityCardNumber());
                    ids.setDateOfExpiry(id.getDateOfExpiry());
                    found=true;
                    break;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ids;
    }

    @Override
    public boolean copyAbsoluteData(File from, File to) throws IOException {
        boolean copied=false;
        PrintWriter printWriter=new PrintWriter(new FileOutputStream(to.getAbsolute(),true));
        try {
            ArrayList<PersonalId> id=parseDataAbsolute(from);
            for (PersonalId ids:id) {
                printWriter.println(ids);
            }
            printWriter.close();
            copied=true;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return copied;
    }

    @Override
    public boolean copyData(File from, File to) throws FileNotFoundException {
        boolean copied=false;
        PrintWriter printWriter=new PrintWriter(new FileOutputStream(to.getFullFileName(),true));
        try {
            ArrayList<PersonalId> id=parseData(from);
            for (PersonalId ids:id) {
               printWriter.println(ids);
            }
            printWriter.close();
            copied=true;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return copied;
    }

    /**
     *
     * @param identityCardNumber
     * @param personalId
     * @param upd
     * @return true if update was successfull
     * @throws IOException if file not found
     * first function fetch all the data from file to array
     * creates new array to store new updated values and other values added from file
     * find the object in data by identity card number
     * if object part is empty do not update anything
     * if object part is not empty string or 0 day
     * update new object fetched by function
     * when new values are set
     * for each object in array list
     * add to new list new object if it is equal to id card number
     * else add other data from file
     * delete file
     * when new list is made
     * every object write to external file
     */
    @Override
    public boolean updateData(String identityCardNumber,PersonalId personalId, File upd) throws IOException {
        boolean success=false;
        String empty="";
        ArrayList<PersonalId> personalIds=parseData(upd);
        ArrayList<PersonalId> updatedData=new ArrayList<PersonalId>();
        PersonalId updatedValues=findObject(identityCardNumber,upd);
        System.out.println("Old object:"+updatedValues);
        if(personalId.getIdentityCardNumber().equals(empty)){

        }else{
            System.out.println("Identify card number cannot be updated.");

            success=false;
        }
        if(personalId.getDateOfExpiry().getDay()==0){

        }else{

            updatedValues.setDateOfExpiry(personalId.getDateOfExpiry());
            System.out.println("Updated date. ID now expires at"+personalId.getDateOfExpiry());
            success=true;
        }
        if(personalId.getSurname().equals(empty)){

        }else{

            updatedValues.setSurname(personalId.getSurname());
            System.out.println("Updated surname");
            success=true;
        }
        if(personalId.getName().equals(empty)){

        }else{

            updatedValues.setName(personalId.getName());
            System.out.println("Your name has been updated");
            success=true;
        }
        if(personalId.getSex()==' '){

        }else{

            System.out.println("Your sex cannot be changed.");
            success=false;
        }
        if(personalId.getCitizenship().equals(empty)){

        }else{

            updatedValues.setCitizenship(personalId.getCitizenship());
            System.out.println("Your citizenship has been updated.");
            success=true;
        }
        if(personalId.getDateOfBirth().equals(empty)){

        }else{

            System.out.println("Your date of birth cannot be updated.");
            success=false;
        }
        if(personalId.getResidence().equals(empty)){

        }else{

            personalId.setResidence(personalId.getResidence());
            System.out.println("Your residence has been updated");
            success=true;
        }
        if(personalId.getIssuedBy().equals(empty)){

        }else{

            personalId.setIssuedBy(personalId.getIssuedBy());
            System.out.println("Id which has been issued by has been changed. New place is:"+personalId.getIssuedBy());
            success=true;
        }
        if(personalId.getDateOfIssue().equals(empty)){

        }else{

            personalId.setDateOfIssue(personalId.getDateOfIssue());
            System.out.println("Date of issuse has been changed");
            success=true;
        }
        if(personalId.getPersonalIdentificationNumber().equals(empty)){

        }else{
            updatedValues.setPersonalIdentificationNumber(personalId.getPersonalIdentificationNumber());
            System.out.println("You cant change your personal identification number");
            success=false;
        }

        for (PersonalId idsa:personalIds) {
            if(identityCardNumber.equals(idsa.getIdentityCardNumber())){
                updatedData.add(updatedValues);
            }else{
                updatedData.add(idsa);
            }
        }
        upd.deleteFile(upd);
        for (PersonalId ids:updatedData) {
            writeToTextFile(ids,upd);
            success=true;
        }
        System.out.println("New object"+updatedValues);
        return success;
    }

    @Override
    public boolean deleteData(String number, File del) throws IOException {
        boolean success=false;
        ArrayList<PersonalId> ids=parseData(del);
        ArrayList<PersonalId> newIds=new ArrayList<PersonalId>();
        del.deleteFile(del);
        for (PersonalId idsa:ids) {
         if(idsa.getIdentityCardNumber().equals(number)){
             success=true;
             continue;

         }else{
             newIds.add(idsa);
         }
        }
        PrintWriter printWriter=new PrintWriter(new FileOutputStream(del.getFullFileName(),true));
        for(PersonalId personalId:newIds){
            printWriter.println(personalId);
            success=true;
        }
        printWriter.close();
        return success;
    }

    @Override
    public boolean findItemByPIN(String PIN,File files)  {
        PersonalId ids=new PersonalId();
        boolean found=false;
        try {
            ArrayList<PersonalId> list=parseData(files);
            for (PersonalId id:list) {
                if(PIN.equals(id.getPersonalIdentificationNumber())){
                    ids.setPersonalIdentificationNumber(id.getPersonalIdentificationNumber());
                    ids.setDateOfIssue(id.getDateOfIssue());
                    ids.setIssuedBy(id.getIssuedBy());
                    ids.setResidence(id.getResidence());
                    ids.setDateOfBirth(id.getDateOfBirth());
                    ids.setCitizenship(id.getCitizenship());
                    ids.setSex(id.getSex());
                    ids.setName(id.getName());
                    ids.setSurname(id.getSurname());
                    ids.setIdentityCardNumber(id.getIdentityCardNumber());
                    ids.setDateOfExpiry(id.getDateOfExpiry());
                    found=true;
                    break;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return found;
    }

    public File(String directory, String fileName, String extension) {
        this.directory = directory;
        this.separateBy = "/";
        this.fileName = fileName;
        this.extension = extension;
    }

    public File() {

        this.directory="C:\\Users\\"+getSystemProperty()+"\\IdeaProjects\\DataProcessing\\"+"personalDirectory";
        this.separateBy="\\";
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
    public String readFromFile(File file, int number) {
        Scanner inputStream=null;
        String podatak="";
        try {
            inputStream=new Scanner(new FileInputStream(file.getFullFileName()));

            for (int i=0;i<number;i++){

                  if(inputStream.hasNextLine()){
                      podatak+=inputStream.nextLine()+"\n";
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
        return podatak;
    }


    @Override
    public String readFromTextFile(File file) {
        Scanner inputStream=null;
        String data="";
        try {
            inputStream=new Scanner(new FileInputStream(file.getFullFileName()));
            while (inputStream.hasNextLine()){
                data+=inputStream.nextLine()+"\n";
                System.out.println(data);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
      return data;
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
        PersonalId idsa=new PersonalId();
        File file=new File();
        for (int i=0;i<number;i++){
            System.out.println("Enter identity card number:");
            id.setIdentityCardNumber(scanner.nextLine());
            if(PersonalId.errors==true){
                break;
            }
            System.out.println("Enter date of expire:");
            System.out.println("Enter day:");
            int day=scanner.nextInt();
            System.out.println("Enter month");
            int month=scanner.nextInt();
            System.out.println("Enter year:");
            int year=scanner.nextInt();
            id.setDateOfExpiry(new Date(day,month,year));
            if(Date.errors==true){
                System.out.println("Wrong date entered!!!");
                break;
            }
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
            if(Date.errors==true){
                System.out.println("Wrong date entered!!!");
                break;
            }
            scanner.nextLine();
            System.out.println("Enter residence:");
            id.setResidence(scanner.nextLine());
            if(PersonalId.errors==true){
                break;
            }
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
            if(Date.errors==true){
                System.out.println("Wrong date entered!!!");
                break;
            }
            scanner.nextLine();
            System.out.println("Enter personal identification number:");
            id.setPersonalIdentificationNumber(scanner.nextLine());
            ids[i]=new PersonalId(id.getIdentityCardNumber(),id.getDateOfExpiry(),id.getSurname(),id.getName(),id.getSex(),id.getCitizenship(),id.getDateOfBirth(),id.getResidence(),id.getIssuedBy(),id.getDateOfIssue(),id.getPersonalIdentificationNumber());

        }
        return ids;
    }


}
