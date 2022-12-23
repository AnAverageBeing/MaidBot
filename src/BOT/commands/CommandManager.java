package BOT.commands;

import BOT.Maid;
import BOT.commands.impl.help;
import BOT.commands.impl.nekosfun;
import BOT.commands.impl.ping;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

import java.util.ArrayList;

public class CommandManager {

    public static ArrayList<ICommand> commands = new ArrayList<>();

    public CommandManager() {
        CommandManager.registerCommands();
    }

    public static void registerCommands() {
        commands.add(new help());
        commands.add(new ping());
        commands.add(new nekosfun());
    }

    public static ArrayList<ICommand> getCommands() {
        return commands;
    }

    public void callCommand(String input, Message message, User sender, Guild guild) {
        String[] split = input.split(" ");
        String command = split[0].replace(Maid.prefix, "");
        System.out.println(command);
        String args = input.substring(command.length()).trim();
        for (ICommand c : getCommands()) {
            if (c.getName().equalsIgnoreCase(command)) {
                try {
                    c.onCommand(args, args.split(" "), message, sender, guild);
                } catch (Exception e) {
                }
                return;
            }
        }
    }
}
