package model;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class PrivateBank implements Strategy {
    private static final String URL_FORMAT = " https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

    public List<CurrencyPair> getCurrenciesPairs() {
        return null;
    }
    private Document getDocument() throws IOException {
        Document document = Jsoup.connect(URL_FORMAT)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36")
                .get();
        return document;
    }
}
