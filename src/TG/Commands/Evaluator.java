package TG.Commands;

import TG.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Evaluator extends BotCommand {

    @Override
    public void command(Message message, String txt, SendMessage reply) {
        if (txt.length()>=6 && txt.substring(0,5).equals("calc ")) {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            String foo = txt.substring(5);
            System.out.println(foo);
            String ans = "?";
            try{
                ans = engine.eval(foo).toString();
            }
            catch (Exception e){

            }
            reply.setText("Answer : " + ans);
        }
    }
}
