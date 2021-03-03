package com.example.javafinance.telegram;

import com.example.javafinance.check.YahooApi;
import com.github.kshashov.telegram.api.MessageType;
import com.github.kshashov.telegram.api.TelegramMvcController;
import com.github.kshashov.telegram.api.bind.annotation.BotController;
import com.github.kshashov.telegram.api.bind.annotation.BotPathVariable;
import com.github.kshashov.telegram.api.bind.annotation.BotRequest;
import com.github.kshashov.telegram.api.bind.annotation.request.MessageRequest;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.math.BigDecimal;

@BotController
public class MyBot implements TelegramMvcController {
    @Value("${telegram.bot.token}")
    private String token;

    @Override
    public String getToken() {
        return token;
    }
    @BotRequest(value = "/hello", type = {MessageType.CALLBACK_QUERY, MessageType.MESSAGE})
    public BaseRequest hello(User user, Chat chat) {
        return new SendMessage(chat.id(), "Hello, " + user.firstName() + "!");
    }
    @BotRequest(value = "/price", type = {MessageType.CALLBACK_QUERY, MessageType.MESSAGE})
    public BaseRequest price(User user, Chat chat) throws IOException {
        YahooApi api = new YahooApi();
        return new SendMessage(chat.id(), "now : " + api.yahooPrice());
    }
    @MessageRequest(value = "/addplussection {section:[[0-9](?:\\.\\d+)?$]+}")
    public BaseRequest addplussection(Chat chat,  @BotPathVariable("section") String section){
        return new SendMessage(chat.id(), "Done"+section);
    }
}