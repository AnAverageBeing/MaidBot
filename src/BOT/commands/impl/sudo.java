package BOT.commands.impl;

import BOT.Maid;
import BOT.commands.ICommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public class sudo implements ICommand{

    @Override
    public String getName() {
        return "sudo";
    }

    @Override
    public String getDescription() {
        return "give a user sudo role";
    }

    @Override
    public String getHelp() {
        return "Usage: "+Maid.prefix+"sudo {user}";
    }

    @Override
    public boolean isAdminCommand() {
        return true;
    }

    @Override
    public void onCommand(String command, String[] args, Message message, User sender, TextChannel channel, Guild guild)
            throws Exception {
    }
    
}
