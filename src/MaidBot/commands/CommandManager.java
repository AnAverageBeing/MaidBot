package MaidBot.commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.util.HashSet;

import MaidBot.Maid;
import MaidBot.commands.impl.help;
import MaidBot.commands.impl.nekosfun;
import MaidBot.commands.impl.ping;
import MaidBot.commands.impl.prefix;
import MaidBot.commands.impl.stop;

public class CommandManager {
    private final static HashSet<ICommand> commands = new HashSet<>();

    public CommandManager() {
        registerCommands();
    }

    private void registerCommands() {
        commands.add(new help());
        commands.add(new nekosfun());
        commands.add(new ping());
        commands.add(new prefix());
        commands.add(new stop());
    }

    public static ICommand[] getCommands() {
        return commands.toArray(new ICommand[0]);
    }

    public void executeCommand(String input, Message message, User sender, TextChannel channel, Guild guild) {
        var parts = input.replaceFirst(Maid.Prefix, "").trim().split("\\s+", 2);
        var command = parts[0];
        var args = parts.length > 1 ? parts[1].split("\\s+") : new String[0];

        commands.stream()
                .filter(cmd -> cmd.getName().equalsIgnoreCase(command))
                .findFirst()
                .ifPresentOrElse(c -> {
                    try {
                        if (c.isAdminCommand() && !guild.getMember(sender).hasPermission(Permission.ADMINISTRATOR)) {
                            channel.sendMessage("This is an Admin-only command!").queue();
                        } else {
                            c.onCommand(input, args, message, sender, channel, guild);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, () -> channel
                        .sendMessage(
                                "Unknown command! Type `" + Maid.Prefix + "help` for a list of available commands.")
                        .queue());
    }
}
