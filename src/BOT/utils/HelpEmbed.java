package BOT.utils;

import java.awt.Color;

import BOT.Maid;
import BOT.commands.CommandManager;
import BOT.commands.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

public class HelpEmbed {
    private static MessageEmbed embed = null;

    static {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setColor(new Color(32, 247, 93))
                .setFooter("Made with ❤️ by CatOnDrugs#1521")
                .setTitle("**HELP**");
        for (ICommand c : CommandManager.getCommands()) {
            embedBuilder.addField(Maid.prefix + c.getName(),
                    c.getDescription() + "\nis Admin Command: `" + c.isAdminCommand() + "`", false);
        }
        embedBuilder.addField("Need More Help?", "use help command followed by a command to get its full detail",
                false);
        embed = embedBuilder.build();
    }

    public static MessageEmbed getembed() {
        return embed;
    }
}
