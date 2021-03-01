package com.example.javafinance.telegram;

import com.example.javafinance.check.Price;
import com.example.javafinance.check.YahooApi;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.IOException;
import java.math.BigDecimal;

public class Bot {
    public static void main(String[] args) throws IOException {

        YahooApi api = new YahooApi();

        BigDecimal test = api.yahooPrice();
        //System.out.println(test);

        Token token = new Token();

        TelegramBot bot = new TelegramBot(token.getTokenid());
        SendMessage request = new SendMessage(token.getChatid(), test.toString())
                .parseMode(ParseMode.HTML)
                .disableWebPagePreview(true)
                .disableNotification(false);

        SendResponse sendResponse = bot.execute(request);
        boolean ok = sendResponse.isOk();
        Message message = sendResponse.message();

    }

}
