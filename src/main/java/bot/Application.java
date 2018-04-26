package bot;

import bot.connection.Connection;
import bot.entities.Info;
import bot.entities.Ticker;
import bot.filemanager.FileManager;
import bot.json.Parser;
import bot.logic.Kernel;
import java.util.*;

public class Application {

    public static void main(String[] args) throws Exception {
        Kernel kernel = new Kernel();
        Connection connection = new Connection();
        Parser parser = new Parser();
        Info info = new Info();
        info.loadInfo();
        List<Ticker> list = kernel.findUnnecessaryTickers(parser.parseAllTickersFromResponseFiles(info));
        FileManager.saveTickerListToFile(list, "unnecessaryTickers.txt");
        System.out.println(list.size());
    }
}
