package BOT.commands.impl;

import BOT.Maid;
import BOT.commands.ICommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

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
        return "Usage: `" + Maid.prefix + "prefix {new prefix}`";
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
        Maid.prefix = newPrefix;
        channel.sendMessage("Prefix updated to `" + newPrefix + "`").queue();
    }
}
