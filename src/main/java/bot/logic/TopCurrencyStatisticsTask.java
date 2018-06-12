package bot.logic;

import bot.connection.Connection;
import bot.entities.Info;
import bot.entities.Ticker;
import bot.filemanager.XLSDocument;
import bot.json.Parser;
import bot.util.Util;

import java.util.List;
import java.util.TimerTask;

public class TopCurrencyStatisticsTask extends TimerTask {

    private Connection connection;
    private Info info;
    private Parser parser;
    private Kernel kernel;
    private String currency;

    public TopCurrencyStatisticsTask(String currency) {
        this.currency = currency;
        kernel = new Kernel();
        connection = new Connection();
        parser = new Parser();
        try {
            info = parser.parseInfo(connection.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        collectInfo();
    }

    private void collectInfo() {
        try {
            connection.getTickerInfoAboutAllPairs(info);
            Util.getRequestsCount(info.getPairs().size());
            Util.getLastRequestPairsCount(info.getPairs().size());
            List<Ticker> tickerList = parser.parseAllTickersFromResponseFiles(info);
            kernel.deleteZeroVolumeTickersFromList(tickerList);
            List<Ticker> btcList = kernel.findTop10CurrencyPairsPerDay(tickerList, currency);
            System.out.println("Load xls file");
            XLSDocument document = new XLSDocument(currency);
            document.load();
            document.addTickerListToXLSDocument(btcList);
            document.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
