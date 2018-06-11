package bot.util;

public class Util {

    public static final int PAIRS_COUNT_IN_ONE_REQUEST = 46;
    public static int REQUESTS_COUNT;
    public static int LAST_REQUEST_PAIRS_COUNT;

    public static int getRequestsCount(int currencyPairsCount) {
        REQUESTS_COUNT = currencyPairsCount / PAIRS_COUNT_IN_ONE_REQUEST;
        return REQUESTS_COUNT;
    }

    public static int getLastRequestPairsCount(int currencyPairsCount) {
        LAST_REQUEST_PAIRS_COUNT = currencyPairsCount % PAIRS_COUNT_IN_ONE_REQUEST;
        return LAST_REQUEST_PAIRS_COUNT;
    }
}
