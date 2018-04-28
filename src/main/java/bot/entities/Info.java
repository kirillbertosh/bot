package bot.entities;

import bot.filemanager.FileManager;

import java.util.*;

public class Info {

    private List<String> pairs = new ArrayList<String>();

    public Info() {

    }

    public void loadInfo() {
        pairs = FileManager.loadInfoFromFile("info.txt");
    }

    public void savePairsToFile(String pairs) {
        FileManager.saveToFile(pairs, "info.txt");
    }

    public List<String> getPairs() {
        return pairs;
    }

    public void setPairs(List<String> pairs) {
        this.pairs = pairs;
    }

    @Override
    public String toString() {
        return "Info{" +
                "pairs=" + pairs +
                '}';
    }
}
