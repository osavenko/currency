package command;

import model.CurrencyPair;
import model.Strategy;

import java.util.List;

public class Bank{
    private Strategy bankStrategy;
    private String bankName;

    public Bank(Strategy bankStrategy, String bankName) {
        this.bankStrategy = bankStrategy;
        this.bankName = bankName;
    }

    public void execute(){
        System.out.println("*********************************");
        System.out.println("Курсы валют - "+bankName);
        printCurrencyPair(bankStrategy.getCurrenciesPairs());
        System.out.println("*********************************");
    }
    private void printCurrencyPair(List<CurrencyPair> currencyPairs){
        for (CurrencyPair c:currencyPairs){
            System.out.println(c);
        }
    }
}
