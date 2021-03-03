package com.example.javafinance.check;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

public class YahooApi {
    public String yahooPrice() throws IOException {
        Stock stock = YahooFinance.get("KRW=X");
        BigDecimal price = stock.getQuote(true).getPrice();
        return price.toString();
    }
}
