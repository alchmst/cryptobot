package TG.Commands;

import TG.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MiscellaneusCommands extends BotCommand {

    @Override
    public void command(Message message, String txt, SendMessage reply) {
        String[] tokenMsg = txt.split(" ");

        switch (tokenMsg[0].toLowerCase()) {
            case "hello":
                reply.setText("Hi.");
                break;
            case "hi":
                reply.setText("Hello.");
                break;
            case "/reverse":
                reply.setText((new StringBuffer(txt.substring(9))).reverse().toString());
                break;
            case "/date":
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                reply.setText(dtf.format(now));
                break;
            case "/id":
                reply.setText("Your chat ID is: " + message.getChatId());
                break;
            case "/fname":
                reply.setText("Your first name is " + message.getChat().getFirstName() + ".");
                break;
            case "/lname":
                reply.setText("Your last name is " + message.getChat().getLastName() + ".");
                break;
            case "/help":
                reply.setText("/help\tget commands\n/id\tchat id\n/price [crypto_currency] [currency]\tget crypto currency rates\n/reverse [msg]");
                break;
            default:
                break;

        }
    }
}