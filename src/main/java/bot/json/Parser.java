package bot.json;

import bot.entities.Info;
import bot.entities.Ticker;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

    public Ticker parseTicker(String ticker, String currencyPair) {
        try {
            Ticker resultTicker = new Ticker();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(ticker);
            JSONObject structure = (JSONObject) jsonObject.get(currencyPair);
            resultTicker.setHigherPrice((Double) structure.get("high"));
            resultTicker.setLowerPrice((Double) structure.get("low"));
            resultTicker.setAveragePrice((Double) structure.get("avg"));
            resultTicker.setVolume((Double) structure.get("vol"));
            resultTicker.setVolumeInCurrency((Double) structure.get("vol_cur"));
            resultTicker.setLastDealPrice((Double) structure.get("last"));
            resultTicker.setBuyPrice((Double) structure.get("buy"));
            resultTicker.setSellPrice((Double) structure.get("sell"));
            resultTicker.setUpdated((Long) structure.get("updated"));
            return resultTicker;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
