package TG.Commands;

import TG.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Evaluator extends BotCommand {

    @Override
    public void command(Message message, String txt, SendMessage reply) {
        String[] command = txt.toLowerCase().split(" ");

        switch (command[0]) {
            case "/calc":
                ScriptEngineManager mgr = new ScriptEngineManager();
                ScriptEngine engine = mgr.getEngineByName("JavaScript");
                String ans = "?";
                try {
                    ans = engine.eval(command[1]).toString();
                } catch (Exception e) {
                    reply.setText("Cannot evaluate. Type /help for list of commands.");
                }
                reply.setText("Answer : " + ans);
                break;
            default:
                break;
        }
    }
}
