package MaidBot.commands.impl;

import MaidBot.Maid;
import MaidBot.commands.ICommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class prefix implements ICommand {

    @Override
    public String getName() {
        return "prefix";
    }

    @Override
    public String getDescription() {
        return "Changes the bot prefix";
    }

    @Override
    public String getHelp() {
        return "Usage: `" + Maid.Prefix + "prefix {new prefix}`";
    }

    @Override
    public boolean isAdminCommand() {
        return true;
    }

    @Override
    public void onCommand(String command, String[] args, Message message, User sender, TextChannel channel, Guild guild)
            throws Exception {
        if (args.length < 1) {
            channel.sendMessage(getHelp()).queue();
            return;
        }
        String newPrefix = args[0];
        Maid.Prefix = newPrefix;
        channel.sendMessage("Prefix updated to `" + newPrefix + "`").queue();
    }
}
