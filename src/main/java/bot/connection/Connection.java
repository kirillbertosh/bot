package bot.connection;

import bot.json.Parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Connection
{
    private URLConnection urlConnection;
    private String userAgent = "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36";
    private String urlString = "https://yobit.net/api/3/";
    private String currencyPair;

    public Connection() throws Exception {

    }

    public void setCurrencyPair(String pair) {
        this.currencyPair = pair;
    }

    public void addCurrencyPairToExisting(String pair) {
        this.currencyPair += "-" + pair;
    }

    public String getInfo() throws Exception {
        urlConnection = new URL(urlString + "info").openConnection();
        urlConnection.setRequestProperty("User-Agent", userAgent);
        urlConnection.connect();

        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public String getTickerInfoAboutPair(String pair) throws Exception {
        urlConnection = new URL(urlString + "ticker/" + pair).openConnection();
        urlConnection.setRequestProperty("User-Agent", userAgent);
        urlConnection.connect();

        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
