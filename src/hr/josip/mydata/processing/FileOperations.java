package hr.josip.mydata.processing;

public interface FileOperations {
   void makeDirectory(File fil);
   void deleteDirectory(File fil);
   void writeToFile(Object o,File file);
   void deleteFile(File file);
}
