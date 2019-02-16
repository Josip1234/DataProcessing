package hr.josip.mydata.processing;

public interface FileOperations extends Id {
   void makeDirectory(File fil);
   void deleteDirectory(File fil);
   void printDirectory(File fil);
   void writeToTextFile(Object o,File file);
   void readFromTextFile(File file);
   String readFromFile(File file,int number);
   void deleteFile(File file);
}
