import model.AvalBank;
import model.CurrencyPair;
import model.PrivateBank;

import java.util.List;

public class main {
    public static void main(String[] args) {
        System.out.println("Курсы ПриватБанка");
        PrivateBank pb = new PrivateBank();
        List<CurrencyPair> currencyPairsPB = pb.getCurrenciesPairs();
        for (CurrencyPair c:currencyPairsPB){
            System.out.println(c);
        }
        System.out.println("Курсы Аваль");
        AvalBank ab = new AvalBank();
        List<CurrencyPair> currencyPairsAB = ab.getCurrenciesPairs();
        for (CurrencyPair c:currencyPairsAB){
            System.out.println(c);
        }

    }
}
