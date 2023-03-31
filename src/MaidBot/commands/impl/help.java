package MaidBot.commands.impl;

import MaidBot.Maid;
import MaidBot.commands.CommandManager;
import MaidBot.commands.ICommand;
import MaidBot.utils.HelpEmbed;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class help implements ICommand {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "helps you";
    }

    @Override
    public String getHelp() {
        return "Usage: `" + Maid.Prefix + "help` or `" + Maid.Prefix + "help {command}`";
    }

    @Override
    public boolean isAdminCommand() {
        return false;
    }

    @Override
    public void onCommand(String command, String[] args, Message message, User sender, TextChannel channel, Guild guild)
            throws Exception {
        if (args.length < 1) {
            channel.sendMessageEmbeds(HelpEmbed.getembed()).queue();
        } else {
            for (ICommand cmd : CommandManager.getCommands()) {
                if (args[0].equalsIgnoreCase(cmd.getName())) {
                    channel.sendMessage(cmd.getHelp()).queue();
                    return;
                }
            }
        }
    }

}
