package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OschadBank implements Strategy{
    private static final String URL_FORMAT = "https://www.oschadbank.ua/ua/private/currency";
    public List<CurrencyPair> getCurrenciesPairs() {
        List<CurrencyPair> currencyPairList = null;
        try {
            Document document = getDocument();
            currencyPairList = new ArrayList<CurrencyPair>();
            Element element = document.getElementById("currency_date_result");
            Elements trs = element.getElementsByTag("tr");
            trs.remove(0);
            for(Element tr: trs) {
                Elements tds = tr.getElementsByTag("td");
                CurrencyPair currencyPair = getPair(tds);
                if (currencyPair!=null){
                    currencyPairList.add(currencyPair);
                }
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
    private CurrencyPair getPair(Elements el){
        CurrencyPair currencyPair = null;
        Currency baseCurrency = new Currency("UAH");
        Currency secondCurrency = null;
        float buy = 0;
        float sale = 0;

        if (el.size()==7){
            if(el.get(0).text().equals("USD")){
                secondCurrency = new Currency("USD");
            } else if(el.get(0).text().equals("EUR")){
                secondCurrency = new Currency("EUR");
            } else if(el.get(0).text().equals("RUB")){
                secondCurrency = new Currency("RUR");
            }
            buy = Float.parseFloat(el.get(5).text().replace(",", ""));
            sale = Float.parseFloat(el.get(6).text().replace(",", ""));
            int mult = Integer.parseInt(el.get(3).text());

            currencyPair = new CurrencyPair(baseCurrency, secondCurrency, buy, sale);
            currencyPair.setMult(mult);
        }
        return currencyPair;
    }
}
