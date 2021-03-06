package bot.logic;

import bot.entities.Ticker;
import java.util.*;

public class Kernel {

    public Kernel() {

    }

    public List<Ticker> findUnnecessaryTickers(List<Ticker> list) {
        List<Ticker> resultList = new ArrayList<>();
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

    public void deleteUnchangingTickersFromList(List<Ticker> list) {
        list.removeIf(
                t -> Math.abs(t.getHigherPrice() / t.getLowerPrice() - 1) < 0.05f
        );
    }

    public void deleteZeroVolumeTickersFromList(List<Ticker> list) {
        list.removeIf(t -> t.getVolume() == 0);
    }

    public List<Ticker> findZeroVolumeTickers(List<Ticker> list) {
        List<Ticker> resultList = new ArrayList<>();
        for (Ticker ticker : list) {
            if (ticker.getVolume() == 0) {
                resultList.add(ticker);
            }
        }
        return resultList;
    }

    public List<Ticker> findTop10CurrencyPairsPerDay(List<Ticker> inputList, String currency) {
        List<Ticker> resultList = new ArrayList<>();
        resultList.addAll(inputList);
        resultList.removeIf(t -> !t.getTickerPairName().contains("_" + currency));
        resultList.sort(Comparator.comparingDouble(Ticker::getVolume));
        Collections.reverse(resultList);
        resultList = resultList.subList(0, 10);

        return resultList;
    }
}
