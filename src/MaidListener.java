import commands.CommandManager;
import commands.HelpManager;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;


public class MaidListener extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        Message message = event.getMessage();
        Guild guild = event.getGuild();
        User sender = event.getAuthor();
        if(message.getContentRaw().equalsIgnoreCase("!help"))
        {
            HelpManager helpManager = new HelpManager();
            helpManager.help(message, sender, guild);
            message.delete();
        }
        CommandManager commandManager = new CommandManager();
        try {
            commandManager.callCommand(message.getContentRaw(), message, sender, guild);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
