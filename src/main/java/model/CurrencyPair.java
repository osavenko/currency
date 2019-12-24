package model;

public class CurrencyPair {
    private Currency firstCurrency = null;
    private Currency secondCurrency = null;
    private long buy;
    private long sell;

    public Currency getFirstCurrency() {
        return firstCurrency;
    }

    public void setFirstCurrency(Currency firstCurrency) {
        this.firstCurrency = firstCurrency;
    }

    public Currency getSecondCurrency() {
        return secondCurrency;
    }

    public void setSecondCurrency(Currency secondCurrency) {
        this.secondCurrency = secondCurrency;
    }

    public long getBuy() {
        return buy;
    }

    public void setBuy(long buy) {
        this.buy = buy;
    }

    public long getSell() {
        return sell;
    }

    public void setSell(long sell) {
        this.sell = sell;
    }

    public CurrencyPair() {
    }

    public CurrencyPair(Currency firstCurrency, Currency secondCurrency, long buy, long sell) {
        this.firstCurrency = firstCurrency;
        this.secondCurrency = secondCurrency;
        this.buy = buy;
        this.sell = sell;
    }
}
