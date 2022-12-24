package BOT;

import BOT.commands.CommandManager;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MaidListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        if(!event.getMessage().getContentRaw().startsWith(Maid.prefix)){
            return;
        }
        if(!event.isFromGuild()){
            return;
        }
        Message message = event.getMessage();
        Guild guild = event.getGuild();
        User sender = event.getAuthor();
        TextChannel channel = event.getTextChannel();
        CommandManager commandManager = new CommandManager();
        //OTHER COMMAND HANDLING
        try {
            commandManager.callCommand(message.getContentRaw(), message, sender, channel, guild);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
