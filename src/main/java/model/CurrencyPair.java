package model;

public class CurrencyPair {
    private Currency baseCurrency = null;
    private Currency secondCurrency = null;
    private float buy;
    private float sale;
    private int mult;

    public Currency getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(Currency baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Currency getSecondCurrency() {
        return secondCurrency;
    }

    public void setSecondCurrency(Currency secondCurrency) {
        this.secondCurrency = secondCurrency;
    }

    public float getBuy() {
        return buy;
    }

    public void setBuy(long buy) {
        this.buy = buy;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(long sale) {
        this.sale = sale;
    }

    public CurrencyPair() {
    }

    public void setMult(int mult) {
        this.mult = mult;
    }

    public CurrencyPair(Currency firstCurrency, Currency secondCurrency, float buy, float sale) {
        this.baseCurrency = firstCurrency;
        this.secondCurrency = secondCurrency;
        this.buy = buy;
        this.sale = sale;
        this.mult = 1;
    }

    @Override
    public String toString() {
        return secondCurrency+(mult==1?"":" "+mult)+" -> "+baseCurrency+": buy("+getBuy()+"), sale("+getSale()+")";
    }
}
