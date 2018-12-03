package TG.Commands;

import TG.BotCommand;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.net.URL;
import java.nio.charset.Charset;

public class ImportantCommands extends BotCommand {

    @Override
    public void command(Message message,String txt, SendMessage reply){
        String[] tokenMsg = txt.split(" ");
        switch (tokenMsg[0]) {
            case "/price":
                try {
                    String currency = tokenMsg[1].toUpperCase();
                    String conversion = tokenMsg[2].toUpperCase();

                    JSONObject json = new JSONObject(IOUtils.toString(new URL("https://min-api.cryptocompare.com/data/pricemulti?fsyms=" + currency + "&tsyms=" + conversion + "&api_key=3767b6363b3853b1f8510dc8d2223e0fee4267649c9fcacaf08c53a1049f4a81"), Charset.forName("UTF-8")));
                    reply.setText(tokenMsg[1].toUpperCase() + " : " + json.getJSONObject(currency).getDouble(conversion) + " " + conversion);
                } catch (Exception e) { reply.setText("Usage: /price [crypto_currency] [currency]"); }
                break;
            default: break;
        }
    }
}
