package bot.filemanager;

import bot.entities.Ticker;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.*;

public class FileManager {

    public FileManager() {

    }

    public static List<String> loadInfoFromFile(String fileName) {
        try {
            List<String> resultList = new ArrayList<String>();
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                resultList.add(scanner.nextLine());
            }
            scanner.close();
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String loadFromFile(String fileName) {
        try {
            String str = new String();
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                str += scanner.nextLine();
            }
            scanner.close();
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

    public static boolean saveTickerResponseToFile(String response, int counter) {
        try {
            FileWriter writer = new FileWriter("tickers" + counter + ".txt");
            writer.write(response);
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void saveZeroVolumeTickersToFile(List<Ticker> list) {
        try {
            FileWriter writer = new FileWriter("zero_tickers.txt");
            for (Ticker ticker : list) {
                writer.write(ticker.toString());
                writer.write("\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean saveTickerListToFile(List<Ticker> list, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Ticker ticker : list) {
                writer.write(ticker.toString());
                writer.write("\n");
            }
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
