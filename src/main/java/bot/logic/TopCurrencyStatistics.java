package bot.logic;

import java.util.Timer;

public class TopCurrencyStatistics {

    private TopCurrencyStatisticsTask task;
    private Timer timer;
    private int period = 1000 * 60 * 60;
    private int delay = 0;
    private String currency;

    public TopCurrencyStatistics(String currency) {
        task = new TopCurrencyStatisticsTask(currency);
    }
    
    public void startCollectStatistics() {
        timer = new Timer();
        timer.scheduleAtFixedRate(task, delay, period);
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void cancelCollectStatistics() {
        timer.cancel();
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getDelay() {
        return delay;
    }

    public int getPeriod() {
        return period;
    }
}
