package TG;

import misc.ClassFinder;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class CryptoBot extends TelegramLongPollingBot {
    private List<Class<?>> commandClasses;
    public CryptoBot(){
        commandClasses = ClassFinder.find("TG.Commands");
    }

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            SendMessage reply = new SendMessage() // Create a SendMessage object with mandatory fields
                .setChatId(update.getMessage().getChatId())
                .setText("");

            for (int i=0;i<commandClasses.size();i++){
                BotCommand cl = null;
                try {
                    cl = (BotCommand)commandClasses.get(i).newInstance();
                }
                catch(Exception e){}
                if (cl != null){
                    cl.command(message,message.getText(),reply);
                }
            }

            if (!reply.getText().isEmpty()) {
                try {
                    execute(reply); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "CryptoBot";
    }

    @Override
    public String getBotToken() {
        return "767053057:AAH2lamcQ8yF1DOGwhYWI9eExoVvApKwLPU";
    }

}