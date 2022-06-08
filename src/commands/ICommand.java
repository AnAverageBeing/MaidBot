package commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

public interface ICommand {
    public String getName();
    public String getDescription();
    public boolean isAdminCommand();
    public abstract void onCommand(String command, String[] args, Message message, User sender, Guild guild) throws Exception;
}
