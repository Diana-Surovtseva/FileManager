import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Manager {
    public static void main(String[] args) {
        //TODO Menu with loop
        while (true) {
            System.out.println("Choose menu item: ");
            System.out.println("1. Create ");
            System.out.println("2. Delete");
            System.out.println("3. Exist");
            System.out.println("4. Location");
            System.out.println("5. Rename");
            System.out.println("6. ListFilesAndDirectories");
            System.out.println("0. Exit");
            Scanner myObj = new Scanner(System.in);  // Create a object that can read user input
            String menuItem = myObj.nextLine();  // Read user input
            System.out.println("Menu item is: " + menuItem);
            if (menuItem.contains("0") || menuItem.contains("exit")) {
                break;
            }
            File file = new File("C:\\Users\\Diana\\IdeaProjects\\FileManager\\src\\TestFile");
            boolean result;
            switch (menuItem) {

                case "1":
                    result = createEmptyFile(file);
                    System.out.println("File was created: " + result);
                    break;
                case "2":
                    result = deleteFile(file);
                    System.out.println("File was deleted: " + result);
                    break;
                case "3":
                    result = fileExist(file);
                    System.out.println("File exist: " + result);
                    break;
                case "4":
                    currentLocation(file);
                    System.out.println("File path: " + currentLocation(file));
                    break;
                case "5":
                    createEmptyFile(file);
                    result = rename(file);
                    System.out.println("File rename: " + result);
                    break;
                case "6":
                    System.out.println("This is list of files in directoties: ");
                    listOfFilesAndDirectories(file.getParent());

            }
        }
    }

    public static void listOfFilesAndDirectories(String dirPath) {
        File dir = new File(dirPath);
        File[] fileArray = dir.listFiles();
        for (File file : fileArray) {
            System.out.println(file.getAbsolutePath());
        }
    }

    public static boolean createEmptyFile(File file) {
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean rename(File file) {
        try {
            String newAbsolutePath = file.getAbsolutePath().replace(file.getName(), "SecondFile");
            File file2 = new File(newAbsolutePath);
            return file.renameTo(file2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteFile(File file) {
        return file.delete();

    }

    public static String currentLocation(File file) {
        return file.toPath().toString();
    }

    public static boolean fileExist(File file) {
        return file.exists();
    }
}
