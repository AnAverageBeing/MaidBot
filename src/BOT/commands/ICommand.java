package BOT.commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public interface ICommand {
    public String getName();

    public String getDescription();

    public String getHelp();

    public boolean isAdminCommand();

    public abstract void onCommand(String command, String[] args, Message message, User sender, TextChannel channel,
            Guild guild)
            throws Exception;
}
