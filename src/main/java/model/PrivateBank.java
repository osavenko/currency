package model;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrivateBank implements Strategy {
    private static final String URL_FORMAT = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";

    public List<CurrencyPair> getCurrenciesPairs() {
        List<CurrencyPair> currencyPairList = null;
        try {
            Document document = getDocument();
            currencyPairList = new ArrayList<CurrencyPair>();
            for(Element e:document.select("exchangerate")){
                Currency baseCurrency = new Currency(e.attr("base_ccy"));
                Currency secondCurrency = new Currency(e.attr("ccy"));
                float buy = Float.parseFloat(e.attr("buy"));
                float sale = Float.parseFloat(e.attr("sale"));
                currencyPairList.add(new CurrencyPair(baseCurrency, secondCurrency, buy, sale));
            }
        }catch (IOException ignore){

        }
        return currencyPairList;
    }
    private Document getDocument() throws IOException {
        Document document = Jsoup.connect(URL_FORMAT)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36")
                .get();
        return document;
    }
}
