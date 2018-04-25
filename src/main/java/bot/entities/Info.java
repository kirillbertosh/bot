package bot.entities;

import bot.filemanager.FileManager;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Info {

    private String[] pairs = new String[7052];

    public Info() {

    }

    public void loadInfo() {
        try {
            int i = 0;
            Scanner scanner = new Scanner(new File("info.txt"));
            while (scanner.hasNext()) {
                pairs[i] = scanner.nextLine();
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void savePairsToFile(String pairs) {
        FileManager.saveToFile(pairs, "info.txt");
    }

    public String[] getPairs() {
        return pairs;
    }

    @Override
    public String toString() {
        return "Info{" +
                "pairs=" + Arrays.toString(pairs) +
                '}';
    }
}
