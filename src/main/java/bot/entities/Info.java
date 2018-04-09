package bot.entities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        FileWriter writer = null;
        try {
            writer = new FileWriter("info.txt");
            writer.write(pairs);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
