import model.CurrencyPair;
import model.PrivateBank;

import java.util.List;

public class main {
    public static void main(String[] args) {
        PrivateBank pb = new PrivateBank();
        List<CurrencyPair> currencyPairsPB = pb.getCurrenciesPairs();
        for (CurrencyPair c:currencyPairsPB){
            System.out.println(c);
        }
    }
}
