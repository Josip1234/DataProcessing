package hr.josip.mydata.processing;

public interface FileOperations extends Id {
   void makeDirectory(File fil);
   void deleteDirectory(File fil);
   void printDirectory(File fil);
   void writeToFile(Object o,File file);
   void deleteFile(File file);
}
