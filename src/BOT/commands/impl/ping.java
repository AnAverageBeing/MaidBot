package BOT.commands.impl;

import BOT.commands.ICommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

import java.time.temporal.ChronoUnit;

public class ping implements ICommand {
    public String getName() {
        return "ping";
    }

    public String getDescription() {
        return "command used to check BOT's latency.";
    }

    @Override
    public String getHelp() {
        return "use this command to check BOT's latency.";
    }

    public boolean isAdminCommand() {
        return false;
    }

    @Override
    public void onCommand(String command, String[] args, Message message, User sender, Guild guild) throws Exception {
        Message message1 = message.getChannel().sendMessage("Pinging...").complete();
        long ping = message.getTimeCreated().until(message1.getTimeCreated(), ChronoUnit.MILLIS);
        message1.editMessage("> **Ping:** **`" + ping + "`** **ms**").queue();
    }

}
