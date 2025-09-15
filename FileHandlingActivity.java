import java.io.*;

public class FileHandlingActivity {
    public static void createDirectory(String dirPath, String dirName){
        if (!dirPath.equals("")){
            dirPath += "/";
        }
        File dir = new File(dirPath + dirName);
        dir.mkdir();
    }

    public static void createFile(String dirPath, String fileName){
        File f = new File(dirPath + "/" + fileName);
        try {
            f.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void writeToFile(String filePath, String content){
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(String filePath){
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (sb.length() > 1){
            sb.deleteCharAt(sb.length() - 1); //remove terminator
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Your code here
        
        // a. Create main directory
        createDirectory("", "JavaFileSystem");

        // b. Create three text files
        createFile("JavaFileSystem", "notes.txt");
        createFile("JavaFileSystem", "log.txt");
        createFile("JavaFileSystem", "data.txt");
    
        // c. Write messages to files
        writeToFile("JavaFileSystem/notes.txt", "This is the notes file!");
        writeToFile("JavaFileSystem/log.txt", "This is the second file, the log file!");
        writeToFile("JavaFileSystem/data.txt", "This is the third file, the data file!");
        
        // d. Read and display file contents
        System.out.println(readFile("JavaFileSystem/notes.txt"));
        System.out.println(readFile("JavaFileSystem/log.txt"));
        System.out.println(readFile("JavaFileSystem/data.txt"));
        
        // e. Create backup directory
        createDirectory("", "Backup");
        
        // f. Copy contents to backup file
        
        // g. List all files in both directories
    }
}