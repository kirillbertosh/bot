package bot.entities;

public class Ticker {

    private double higherPrice;
    private double lowerPrice;
    private double averagePrice;
    private double volume;
    private double volumeInCurrency;
    private double lastDealPrice;
    private double buyPrice;
    private double sellPrice;
    private long updated;

    public Ticker() {

    }

    public double getHigherPrice() {
        return higherPrice;
    }

    public void setHigherPrice(double higherPrice) {
        this.higherPrice = higherPrice;
    }

    public double getLowerPrice() {
        return lowerPrice;
    }

    public void setLowerPrice(double lowerPrice) {
        this.lowerPrice = lowerPrice;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getVolumeInCurrency() {
        return volumeInCurrency;
    }

    public void setVolumeInCurrency(double volumeInCurrency) {
        this.volumeInCurrency = volumeInCurrency;
    }

    public double getLastDealPrice() {
        return lastDealPrice;
    }

    public void setLastDealPrice(double lastDealPrice) {
        this.lastDealPrice = lastDealPrice;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
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
                "higherPrice=" + higherPrice +
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
