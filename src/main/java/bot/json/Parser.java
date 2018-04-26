package bot.json;

import bot.entities.Info;
import bot.entities.Ticker;
import bot.filemanager.FileManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.*;

public class Parser {

    private JSONParser jsonParser;

    public Parser() {
        jsonParser = new JSONParser();
    }

    public Info parseInfo(String info) {
        info = info.substring(35, info.length());
        info = info.replaceAll("\\{.*?\\}", "");
        info = info.replaceAll(":","");
        info = info.replaceAll(",", "\n");
        info = info.replaceAll(":}}","");
        info = info.replaceAll("}}","");
        info = info.replaceAll("\"", "");

        Info resultInfo = new Info();
        resultInfo.savePairsToFile(info);
        resultInfo.loadInfo();
        return resultInfo;
    }

    public List<Ticker> parseAllTickersFromResponseFiles(Info info) {
        List<Ticker> tickerList = new ArrayList<Ticker>();
        int counter = 0;
        for (int i = 0; i < 164; i++) {
            String tickerResponse = FileManager.loadFromFile("tickers" + i + ".txt");
            for (int j = 0; j < 43; j++) {
                try {
                    JSONObject jsonObject = (JSONObject) jsonParser.parse(tickerResponse);
                    JSONObject structure = (JSONObject) jsonObject.get(info.getPairs()[counter]);
                    Ticker ticker = parseTicker(structure, info.getPairs()[counter]);
                    tickerList.add(ticker);
                    System.out.println(counter);
                    counter++;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return tickerList;
    }

    public List<Ticker> parseAllTickers(String tickers, Info info) {
        try {
            List<Ticker> tickerList = new ArrayList<Ticker>();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(tickers);
            JSONObject structure = (JSONObject) jsonObject.get(info.getPairs()[0]);
            System.out.println(structure);
            return tickerList;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Ticker parseTicker(JSONObject structure, String currencyPair) {
        Ticker resultTicker = new Ticker();
        resultTicker.setTickerPairName(currencyPair);
        resultTicker.setHigherPrice(
                structure.get("high").equals(0L) ? 0 : new Double(structure.get("high").toString()));
        resultTicker.setLowerPrice(
                structure.get("low").equals(0L) ? 0 : new Double(structure.get("low").toString()));
        resultTicker.setAveragePrice(
                structure.get("avg").equals(0L) ? 0 : new Double(structure.get("avg").toString()));
        resultTicker.setVolume(
                structure.get("vol").equals(0L) ? 0 : new Double(structure.get("vol").toString()));
        resultTicker.setVolumeInCurrency(
                structure.get("vol_cur").equals(0L) ? 0 : new Double(structure.get("vol_cur").toString()));
        resultTicker.setLastDealPrice(
                structure.get("last").equals(0L) ? 0 : new Double(structure.get("last").toString()));
        resultTicker.setBuyPrice(
                structure.get("buy").equals(0L) ? 0 : new Double(structure.get("buy").toString()));
        resultTicker.setSellPrice(
                structure.get("sell").equals(0L) ? 0 : new Double(structure.get("sell").toString()));
        resultTicker.setUpdated((Long) structure.get("updated"));
        System.out.println(resultTicker.toString());
        return resultTicker;
    }
}
