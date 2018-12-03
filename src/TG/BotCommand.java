package TG;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class BotCommand {
    public Boolean triggered = false;
    public Boolean passable = false;
    public BotCommand(){

    }

    public void command(Message message, String txt, SendMessage reply){

    }
}
