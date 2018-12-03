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
        if (txt.toLowerCase().matches("\bhi\b")) {
            reply.setText("Hello.");
        }
        if (txt.toLowerCase().matches("\bhello\b")) {
            reply.setText("Hi.");
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
                    reply.setText("/help\tget commands\n/id\tchat id\n/price [crypto_currency] [currency]\tget crypto currency rates\n/reverse [msg]\ncalc [expression]");
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            reply.setText("Argument invalid. Type /help for list of commands.");
        }
    }
}