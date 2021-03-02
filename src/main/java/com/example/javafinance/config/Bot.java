package com.example.javafinance.config;

import com.github.kshashov.telegram.api.TelegramMvcController;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

//import com.github.kshashov.telegram.*;


@Data
public class Bot implements TelegramMvcController {

    /*
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
*/

    @Value("${bot.token}")
    private String token;

    @Override
    public String getToken() {
        return token;
    }

    /*
    public static void main(String[] args) throws IOException {
        YahooApi api = new YahooApi();

        BigDecimal test = api.yahooPrice();








    }

     */



}
