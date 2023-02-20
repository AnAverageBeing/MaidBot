package BOT.commands;

import BOT.Maid;
import BOT.commands.impl.help;
import BOT.commands.impl.nekosfun;
import BOT.commands.impl.ping;
import BOT.commands.impl.prefix;
import BOT.commands.impl.stop;
import BOT.commands.impl.update;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.ArrayList;

public class CommandManager {

    public static ArrayList<ICommand> commands = new ArrayList<>();

    public CommandManager() {
        CommandManager.registerCommands();
    }

    public static void registerCommands() {
        commands.add(new help());
        commands.add(new prefix());
        commands.add(new update());
        commands.add(new ping());
        commands.add(new stop());
        commands.add(new nekosfun());
    }

    public static ArrayList<ICommand> getCommands() {
        return commands;
    }

    public void callCommand(String input, Message message, User sender, TextChannel channel, Guild guild) {
        String[] split = input.split(" ");
        String command = split[0].replace(Maid.prefix, "");
        String[] args = new String[split.length - 1];
        for (int i = 1; i < split.length; i++) {
            args[i - 1] = split[i];
        }
        for (ICommand c : getCommands()) {
            if (c.getName().equalsIgnoreCase(command)) {
                try {
                    if (c.isAdminCommand()) {
                        if (!guild.getMember(sender).hasPermission(Permission.ADMINISTRATOR)) {
                            channel.sendMessage("This is Admin only command!").queue();
                            return;
                        }
                    }
                    c.onCommand(input, args, message, sender, channel, guild);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }
}
