package com.example.javafinance.check;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

public class YahooApi {
    //Price current_price

    public BigDecimal yahooPrice() throws IOException {
        Stock stock = YahooFinance.get("KRW=X");

        BigDecimal price = stock.getQuote().getPrice();
        //current_price.setCurrent_price(price);
        //System.out.println(current_price.getCurrent_price());
        return price;
    }

/*
    public static void main(String[] args) throws IOException {
        Stock stock = YahooFinance.get("KRW=X");
        BigDecimal price = stock.getQuote().getPrice();
        System.out.println(price);
    }
    */


}
