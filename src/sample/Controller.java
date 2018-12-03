package sample;
/*
WewXDBot
640775922:AAFwz_RNP1wdZJKAI_c8NOFQyQ7uFB4Kxm8

# https://api.telegram.org/bot780928513:AAHlMiD1zrO5fv6DBzXO6e4xqLnFQPmTx8w/getUpdates
# https://api.telegram.org/bot780928513:AAHlMiD1zrO5fv6DBzXO6e4xqLnFQPmTx8w/setWebHook?url=https://b4670c15.ngrok.io
# https://api.telegram.org/bot780928513:AAHlMiD1zrO5fv6DBzXO6e4xqLnFQPmTx8w/getWebhookInfo

*/

import TG.CryptoBot;
import misc.Database;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Controller {
    public void initialize(){
        Database.init();
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(new CryptoBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
