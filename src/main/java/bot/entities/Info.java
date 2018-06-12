package bot.entities;

import java.util.*;

public class Info {

    private List<String> pairs = new ArrayList<>();

    public Info() {

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
