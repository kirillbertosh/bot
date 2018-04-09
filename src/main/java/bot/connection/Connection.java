package bot.connection;

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
        this.currencyPair += "_" + pair;
    }

    public void getInfo() throws Exception {
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

        System.out.println(response.toString());
    }

    public void getTickerInfoAboutPair(String pair) throws Exception {
        this.currencyPair = pair;
        urlString += "ticker/";
        urlString += currencyPair;

        urlConnection = new URL(urlString).openConnection();
        urlConnection.setRequestProperty("User-Agent", userAgent);
        urlConnection.connect();

        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());

    }
}
