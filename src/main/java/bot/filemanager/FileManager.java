package bot.filemanager;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileManager {

    public FileManager() {

    }

    public static String loadFromFile(String fileName) {
        try {
            String str = new String();
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                str += scanner.nextLine();
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean saveToFile(String data, String fileName) {
        try {
            FileWriter writer;
            writer = new FileWriter(fileName);
            writer.write(data);
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
