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

    public static File[] listFiles(String dirPath){
        File dir = new File(dirPath);
        return dir.listFiles();
    }

    public static void debugFileOperation(){
        try {
            // Creating a file with an invalid name (forward slash is invalid for file names on many OS)
            File file = new File("fileName.txt"); //FIXED: removed '/'

            // Attempting to write to the invalid file
            FileWriter writer = new FileWriter(file);
            writer.write("Will this fail?");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace(); 
        }
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
        String combinedData = "NOTES:\n" + readFile("JavaFileSystem/notes.txt") + 
        "\nLOG:\n" + readFile("JavaFileSystem/log.txt") + "\nDATA:\n" + readFile("JavaFileSystem/data.txt"); 
        createFile("Backup", "backup.txt");
        writeToFile("Backup/backup.txt", combinedData);

        // g. List all files in both directories
        File[] JavaFileSystemFiles = listFiles("JavaFileSystem");
        File[] BackupFiles = listFiles("Backup");
        
        System.out.println("Main files:");
        for (File f : JavaFileSystemFiles){
            System.out.println(f.getName());
        }
        System.out.println("Backup files:");
        for (File f : BackupFiles){
            System.out.println(f.getName());
        }

        debugFileOperation();
    }
}