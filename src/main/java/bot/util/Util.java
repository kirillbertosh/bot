package bot.util;

import java.util.*;

public class Util {

    private static final int maxPairsInOneRequest = 50;

    private static List<Integer> getSimpleMultipliers(int number) {
        List<Integer> resultList = new ArrayList<Integer>();
        int divider = 2;
        while (number != 1) {
            if (number % divider == 0) {
                number /= divider;
                resultList.add(divider);
            } else {
                divider++;
            }
        }
        return resultList;
    }

    public static int getRequestsCount(int currencyPairsCount) {
        List<Integer> simpleMultipliers = getSimpleMultipliers(currencyPairsCount);
        int result = 1;
        for (int number : simpleMultipliers) {
            result *= number;
            if (result > maxPairsInOneRequest) {
                result /= number;
                break;
            }
        }
        return result;
    }

    public static int getPairsCountInOneRequest(int currencyPairsCount) {
        return currencyPairsCount / getRequestsCount(currencyPairsCount);
    }
}
