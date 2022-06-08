package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;

import java.awt.*;

public class HelpManager {
    public void help(Message message, User sender, Guild guild) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder
                .setColor(new Color(32, 247, 93))
                .setFooter("MADE BY vortexD#1521")
                .setTitle("**HELP**");
        for (ICommand c : CommandManager.getCommands()) {
            embedBuilder.addField(c.getName(), c.getDescription(), false);
        }
        MessageEmbed messageEmbed = embedBuilder.build();
        //send embed
        message.getChannel().sendMessageEmbeds(messageEmbed).queue();
    }
}
