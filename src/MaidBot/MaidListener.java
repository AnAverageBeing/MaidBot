package MaidBot;

import MaidBot.commands.CommandManager;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MaidListener extends ListenerAdapter {

    private final CommandManager commandManager;

    public MaidListener(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot() || !event.isFromGuild()
                || !event.getMessage().getContentRaw().startsWith(Maid.Prefix)) {
            return;
        }

        Message message = event.getMessage();
        Guild guild = event.getGuild();
        User sender = event.getAuthor();
        TextChannel channel = event.getChannel().asTextChannel();

        try {
            commandManager.executeCommand(message.getContentRaw(), message, sender, channel, guild);
        } catch (IllegalArgumentException | IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
