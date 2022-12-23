package BOT.utils;

import java.awt.Color;

import BOT.commands.CommandManager;
import BOT.commands.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;

public class HelpEmbed {
    public static EmbedBuilder getEmbedBuilder() {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setColor(new Color(32, 247, 93))
                .setFooter("Made with ❤️ by CatOnDrugs#1521")
                .setTitle("**HELP**");
        for (ICommand c : CommandManager.getCommands()) {
            embedBuilder.addField(c.getName(), c.getDescription(), false);
        }
        embedBuilder.addField("Need More Help?","use help command followed by a command to get its full detail", false);
        return embedBuilder;
    }
}
