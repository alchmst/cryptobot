package TG.Commands;

import TG.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class Reverser extends BotCommand {

    @Override
    public void command(Message message, String txt, SendMessage reply) {
        if (txt.length()>=9 && txt.substring(0,8).equals("reverse ")) {
            reply.setText((new StringBuffer(txt.substring(8))).reverse().toString());
        }
    }
}