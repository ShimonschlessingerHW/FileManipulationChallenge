import java.io.*;

public class FileHandlingActivity {
    public static void createFile(String dirPath, String fileName){
        File f = new File(dirPath + "/" + fileName);
        try {
            f.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Your code here
        
        // a. Create main directory
        File mainDir = new File("JavaFileSystem");
        mainDir.mkdir();

        // b. Create three text files
        createFile("JavaFileSystem", "notes.txt");
        createFile("JavaFileSystem", "log.txt");
        createFile("JavaFileSystem", "data.txt");
    
        // c. Write messages to files

        
        // d. Read and display file contents
        
        // e. Create backup directory
        
        // f. Copy contents to backup file
        
        // g. List all files in both directories
    }
}