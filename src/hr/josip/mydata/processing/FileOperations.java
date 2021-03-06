package hr.josip.mydata.processing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface FileOperations extends Id {
   /**
    * Function makes directory
    * @param fil
    */
   void makeDirectory(File fil);

   /**
    * this function deletes directorsy
    * @param fil
    */
   void deleteDirectory(File fil);

   /**
    * This function prints all directory under path
    * @param fil
    */
   void printDirectory(File fil);

   /**
    * this function writes to files some object
    * @param o
    * @param file
    */
   void writeToTextFile(Object o,File file);

   /**
    * this function read from file string values
    * @param file
    * @return string values
    */
   String readFromTextFile(File file);

   /**
    * This function read from file and it has parameter
    * who says how much data you want to read from
    * particular file
    * @param file
    * @param number
    * @return string value
    */
   String readFromFile(File file,int number);

   /**
    * Deletes a current file
    * @param file
    */
   void deleteFile(File file);

   ArrayList<PersonalId> parseData(File file)  throws IOException;
   boolean copyData(File frrom,File to) throws FileNotFoundException;
   boolean deleteData(String number,File del) throws IOException;
   boolean updateData(String identityCardNumber,PersonalId personalId,File upd) throws IOException;
   String readAbsolute(File file) throws IOException;
   boolean copyAbsoluteData(File from,File to) throws IOException;
   ArrayList<PersonalId> parseDataAbsolute(File file)  throws IOException;

}
