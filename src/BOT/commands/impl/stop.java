package BOT.commands.impl;

import BOT.Maid;
import BOT.commands.ICommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public class stop implements ICommand{

    @Override
    public String getName() {
        return "stop";
    }

    @Override
    public String getDescription() {
        return "kills the bot";
    }

    @Override
    public String getHelp() {
        return "Usage: "+Maid.prefix+"stop \n this command stops the bot.";
    }

    @Override
    public boolean isAdminCommand() {
        return true;
    }

    @Override
    public void onCommand(String command, String[] args, Message message, User sender, TextChannel channel, Guild guild)
            throws Exception {
                channel.sendMessage("BYE BYE (uwu)").queue();
    }
    
}
