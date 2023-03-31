package MaidBot.commands.impl;

import MaidBot.Maid;
import MaidBot.commands.ICommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class stop implements ICommand {

    @Override
    public String getName() {
        return "stop";
    }

    @Override
    public String getDescription() {
        return "Kills the Bot.";
    }

    @Override
    public String getHelp() {
        return "Usage: `" + Maid.Prefix + "stop`";
    }

    @Override
    public boolean isAdminCommand() {
        return true;
    }

    @Override
    public void onCommand(String command, String[] args, Message message, User sender, TextChannel channel, Guild guild) throws Exception {
        channel.sendMessage("BYE BYE (uwu)").queue();
        System.exit(0);
    }
}
