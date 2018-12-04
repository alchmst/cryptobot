package TG.Commands;

import TG.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MiscellaneusCommands extends BotCommand {

    @Override
    public void command(Message message, String txt, SendMessage reply) {
        String[] command = txt.split(" ");

        if (txt.toLowerCase().contains("your name")) {
            reply.setText("My name is Cryptobot.");
        }
        if (txt.toLowerCase().matches("hi")) {
            reply.setText("Hello.");
        }
        if (txt.toLowerCase().matches("hello")) {
            reply.setText("Hi.");
        }
        if (txt.toLowerCase().contains("knock knock")) {
            reply.setText("...");
        }

        try {
            switch (command[0].toLowerCase()) {
                case "/reverse":
                    reply.setText((new StringBuffer(command[1])).reverse().toString());
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
                    reply.setText("CryptoBot commands: \n/price [crypto_currency] [currency]\n/id\n/calc [expression]\n/reverse [msg]\n/help");
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            reply.setText("Argument invalid. Type /help for list of commands.");
        }
    }
}