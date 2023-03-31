package MaidBot.commands.impl;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.time.temporal.ChronoUnit;

import MaidBot.Maid;
import MaidBot.commands.ICommand;

public class ping implements ICommand {
    public String getName() {
        return "ping";
    }

    public String getDescription() {
        return "command used to check BOT's latency.";
    }

    @Override
    public String getHelp() {
        return "Usage: `" + Maid.Prefix + "ping`";
    }

    public boolean isAdminCommand() {
        return false;
    }

    @Override
    public void onCommand(String command, String[] args, Message message, User sender, TextChannel channel, Guild guild)
            throws Exception {
        Message message1 = channel.sendMessage("Pinging...").complete();
        long ping = message.getTimeCreated().until(message1.getTimeCreated(), ChronoUnit.MILLIS);
    
        String emoji;
        if (ping <= 200) {
            emoji = "\uD83D\uDFE2"; // green square
        } else if (ping <= 600) {
            emoji = "\uD83D\uDFE1"; // yellow square
        } else {
            emoji = "\uD83D\uDD34"; // red square
        }
    
        message1.editMessage(emoji + " **Ping:** **`" + ping + "`** **ms**").queue();
    }    
}
