package commands;


import commands.impl.ping;
import commands.impl.purge;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

import java.util.concurrent.CopyOnWriteArrayList;

public class CommandManager {

    public static CopyOnWriteArrayList<ICommand> commands = new CopyOnWriteArrayList<>();
    public CommandManager() {
        CommandManager.registerCommands();
    }

    public static void registerCommands() {
        commands.add(new ping());
        commands.add(new purge());
    }

    public static CopyOnWriteArrayList<ICommand> getCommands(){
        return commands;
    }

    public void callCommand(String input, Message message, User sender, Guild guild) {
        String[] split = input.split(" ");
        String command = split[0];
        String args = input.substring(command.length()).trim();
        for (ICommand c : getCommands()) {
            if (c.getName().equalsIgnoreCase(command)) {
                try {
                    c.onCommand(args, args.split(" "), message, sender, guild);
                } catch(Exception e) {}
                return;
            }
        }
    }
}

