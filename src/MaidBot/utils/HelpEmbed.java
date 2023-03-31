package MaidBot.utils;

import java.awt.Color;

import MaidBot.Maid;
import MaidBot.commands.CommandManager;
import MaidBot.commands.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

public class HelpEmbed {

    private static final Color EMBED_COLOR = new Color(32, 247, 93);
    private static final String FOOTER_TEXT = "Made with ❤️ by FatLinuxUser#5841";
    private static final String EMBED_TITLE = "**HELP**";

    public static MessageEmbed getembed() {

        final EmbedBuilder embedBuilder = new EmbedBuilder()
                .setColor(EMBED_COLOR)
                .setFooter(FOOTER_TEXT)
                .setTitle(EMBED_TITLE);

        for (final ICommand c : CommandManager.getCommands()) {
            embedBuilder.addField(Maid.Prefix + c.getName(),
                    c.getDescription() + "\nis Admin Command: **`" + c.isAdminCommand() + "`**", false);
        }

        embedBuilder.addField("Need More Help?",
                "use help command followed by a command to get its full detail", false);

        return embedBuilder.build();
    }
}