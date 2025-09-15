import java.io.*;

public class FileHandlingActivity {
    public static void main(String[] args) {
        // Your code here
        
        // a. Create main directory
        File mainDir = new File("JavaFileSystem");
        mainDir.mkdir();

        // b. Create three text files
        File notes = new File("JavaFileSystem/notes.txt");
        File data = new File("JavaFileSystem/data.txt");
        File log = new File("JavaFileSystem/log.txt");
        
        try {
            notes.createNewFile();
            data.createNewFile();
            log.createNewFile();
        } catch (IOException e){

        }
    
        // c. Write messages to files
        
        // d. Read and display file contents
        
        // e. Create backup directory
        
        // f. Copy contents to backup file
        
        // g. List all files in both directories
    }
}