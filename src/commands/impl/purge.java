package commands.impl;

import commands.ICommand;
import net.dv8tion.jda.api.entities.*;

import java.util.List;

public class purge implements ICommand {
    @Override
    public String getName() {
        return "!purge";
    }

    @Override
    public String getDescription() {
        return "used to purge chat usages: !purge [amount of msg]";
    }

    @Override
    public boolean isAdminCommand() {
        return true;
    }

    @Override
    public void onCommand(String command, String[] args, Message message, User sender, Guild guild) throws Exception {
        Role admin = guild.getRolesByName("[ADMIN]", true).get(0);
        Member member = message.getMember();
        if (member.getRoles().contains(admin)) {
            if (args.length == 1) {
                    int amount = Integer.parseInt(args[0]);
                    if (amount > 0) {
                        List<Message> messages = message.getChannel().getHistory().retrievePast(amount).complete();
                        for(Message msg : messages) {
                            msg.delete().complete();
                        }
                        message.getChannel().sendMessage("Purged " + amount + " messages.").queue();
                    } else {
                        message.getChannel().sendMessage("What dose that even mean").queue();
                    }

            } else {
                message.getChannel().sendMessage("command usage: **!purge [amount of message]**").queue();
            }
        } else {
            message.getChannel().sendMessage("**You are not an admin**\n`ur sussy baka`").queue();
        }
    }
}
