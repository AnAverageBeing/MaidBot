import commands.CommandManager;
import commands.HelpManager;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class MaidListener extends ListenerAdapter {
    
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        Message message = event.getMessage();
        Guild guild = event.getGuild();
        User sender = event.getAuthor();
        CommandManager commandManager = new CommandManager();
        if(message.getContentRaw().equalsIgnoreCase("!help"))
        {
            message.getChannel().sendMessageEmbeds(HelpManager.getEmbedBuilder().build()).queue();
        }
        try {
            commandManager.callCommand(message.getContentRaw(), message, sender, guild);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
