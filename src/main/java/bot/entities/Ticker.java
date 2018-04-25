package bot.entities;

public class Ticker {

    private String tickerPairName;
    private float higherPrice;
    private float lowerPrice;
    private float averagePrice;
    private float volume;
    private float volumeInCurrency;
    private float lastDealPrice;
    private float buyPrice;
    private float sellPrice;
    private long updated;

    public Ticker() {

    }

    public String getTickerPairName() {
        return tickerPairName;
    }

    public void setTickerPairName(String tickerPairName) {
        this.tickerPairName = tickerPairName;
    }

    public float getHigherPrice() {
        return higherPrice;
    }

    public void setHigherPrice(float higherPrice) {
        this.higherPrice = higherPrice;
    }

    public float getLowerPrice() {
        return lowerPrice;
    }

    public void setLowerPrice(float lowerPrice) {
        this.lowerPrice = lowerPrice;
    }

    public float getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(float averagePrice) {
        this.averagePrice = averagePrice;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getVolumeInCurrency() {
        return volumeInCurrency;
    }

    public void setVolumeInCurrency(float volumeInCurrency) {
        this.volumeInCurrency = volumeInCurrency;
    }

    public float getLastDealPrice() {
        return lastDealPrice;
    }

    public void setLastDealPrice(float lastDealPrice) {
        this.lastDealPrice = lastDealPrice;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "tickerPairName='" + tickerPairName + '\'' +
                ", higherPrice=" + higherPrice +
                ", lowerPrice=" + lowerPrice +
                ", averagePrice=" + averagePrice +
                ", volume=" + volume +
                ", volumeInCurrency=" + volumeInCurrency +
                ", lastDealPrice=" + lastDealPrice +
                ", buyPrice=" + buyPrice +
                ", sellPrice=" + sellPrice +
                ", updated=" + updated +
                '}';
    }
}
