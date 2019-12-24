package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AvalBank implements Strategy {
    private static final String URL_FORMAT = "https://ex.aval.ua/ru/personal/everyday/exchange/exchange/";

    public List<CurrencyPair> getCurrenciesPairs() {
        List<CurrencyPair> currencyPairList = null;
        try {
            Document document = getDocument();
            currencyPairList = new ArrayList<CurrencyPair>();
            Elements bodyCurrencys = document.getElementsByClass("body-currency-block-rba");
            if(!bodyCurrencys.isEmpty()){
                Elements trs = bodyCurrencys.get(0).getElementsByTag("tr");
                trs.remove(0);
                for (Element tr: trs){
                    Elements tds = tr.getElementsByTag("td");
                    CurrencyPair currencyPair = getPair(tds);
                    if (currencyPair!=null){
                        currencyPairList.add(currencyPair);
                    }
                }
            }

        }catch (IOException ignore){
            ignore.printStackTrace();
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
        if (el.size()==3){

            if(el.get(0).text().equals("Доллары США")){
                secondCurrency = new Currency("USD");
            } else if(el.get(0).text().equals("Евро")){
                secondCurrency = new Currency("EUR");
            } else if(el.get(0).text().equals("Рубли")){
                secondCurrency = new Currency("RUR");
            } else if(el.get(0).text().equals("Английские фунты стерлингов")){
                secondCurrency = new Currency("GBP");
            } else if(el.get(0).text().equals("Швейцарские франки")){
                secondCurrency = new Currency("CHF");
            }
            buy = Float.parseFloat(el.get(1).text().replace(',','.'));
            sale = Float.parseFloat(el.get(2).text().replace(',','.'));
            currencyPair = new CurrencyPair(baseCurrency, secondCurrency, buy, sale);
        }
        return currencyPair;
    }
}
