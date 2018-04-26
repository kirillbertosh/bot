package bot.logic;

import bot.entities.Ticker;
import java.util.*;

public class Kernel {

    private List<Ticker> unnessasyTickersList = new ArrayList<Ticker>();

    public Kernel() {

    }

    public List<Ticker> findUnnecessaryTickers(List<Ticker> list) {
        List<Ticker> resultList = new ArrayList();
        for(Ticker ticker : list) {
            if (Math.abs(ticker.getHigherPrice() / ticker.getLowerPrice() - 1) < 0.05f) {
                resultList.add(ticker);
                continue;
            }
            if (ticker.getVolume() == 0) {
                resultList.add(ticker);
            }
        }
        return resultList;
    }


}
