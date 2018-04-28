package bot.connection;

import bot.entities.Info;
import bot.filemanager.FileManager;
import bot.variables.Variables;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class Connection
{
    private URLConnection urlConnection;
    private String userAgent = "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36";
    private String urlString = "https://yobit.net/api/3/";

    public Connection() throws Exception {

    }

    public String getInfo() throws Exception {
        urlConnection = new URL(urlString + "info").openConnection();
        urlConnection.setRequestProperty("User-Agent", userAgent);
        urlConnection.connect();

        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

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

    public String getTickerInfoAboutAllPair(Info info) throws Exception {
        List<String> pairs = info.getPairs();
        StringBuilder currencyPairs;
        StringBuilder result = new StringBuilder();

        int counter = 0;

        int k = 0;
        for (int j = 0; j < Variables.REQUESTS_COUNT; j++) {
            currencyPairs = new StringBuilder();
            for (int i = 0; i < Variables.PAIRS_COUNT_IN_ONE_REQUEST; i++) {
                if (currencyPairs.toString().equals("")) {
                    currencyPairs.append(pairs.get(k));
                } else {
                    currencyPairs.append("-");
                    currencyPairs.append(pairs.get(k));
                }
                k++;
            }
            urlConnection = new URL(urlString + "ticker/" + currencyPairs).openConnection();
            urlConnection.setRequestProperty("User-Agent", userAgent);
            urlConnection.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            FileManager.saveTickerResponseToFile(response.toString(), counter);
            counter++;

            System.out.println("Request");

            result.append(response);
            in.close();
            Thread.sleep(500);
        }
        return result.toString();
    }
}
