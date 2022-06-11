package commands;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;

public class HelpManager {
   public static EmbedBuilder getEmbedBuilder() {
    EmbedBuilder embedBuilder = new EmbedBuilder()
                    .setColor(new Color(32, 247, 93))
                    .setFooter("MADE BY vortexD#1521")
                    .setTitle("**HELP**");
            for (ICommand c : CommandManager.getCommands()) {
                embedBuilder.addField(c.getName(), c.getDescription(), false);
            }
       return embedBuilder;
   }
}
