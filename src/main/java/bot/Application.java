package bot;

import bot.connection.Connection;

public class Application {

    public static void main(String[] args) throws Exception {
        Connection connection = new Connection();
        connection.getTickerInfoAboutPair("ltc_btc");
        //connection.getInfo();
    }
}
