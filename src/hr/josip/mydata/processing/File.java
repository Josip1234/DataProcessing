package hr.josip.mydata.processing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
    public void writeToFile(Object o,File fil) {
        if(o instanceof PersonalId){
            try{
                ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fil.getDirectory()+fil.getSeparateBy()+fil.getFileName()+fil.getExtension(),true));
                stream.writeObject(o.toString());
                System.out.println("Data has been written!");
                stream.close();

            } catch (IOException e) {
                e.printStackTrace();

            }
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
}
