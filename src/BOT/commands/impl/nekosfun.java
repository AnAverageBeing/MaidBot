package BOT.commands.impl;

import BOT.Maid;
import BOT.commands.ICommand;
import BOT.utils.NekosFun;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public class nekosfun implements ICommand {

    @Override
    public String getName() {
        return "rstuff";
    }

    @Override
    public String getDescription() {
        return "sends random anime image or gifs for a given tag";
    }

    @Override
    public String getHelp() {
        return "Usage: `" + Maid.prefix + "rstuff {tag}`" +
                "\n\n**Tags:**\n\n" +
                "NSFW TAGS: ```4k,ass,blowjob,boobs,cum,feet,hentai,spank,gasm,lesbian,lewd,pussy```" + "\n" +
                "SFW TAGS: ```kiss,lick,hug,baka,poke,cry,smug,slap,tickle,pat,laugh,feed,cuddle,wallpapers```";
    }

    @Override
    public boolean isAdminCommand() {
        return false;
    }

    @Override
    public void onCommand(String command, String[] args, Message message, User sender, TextChannel channel, Guild guild)
            throws Exception {
        if (!message.isFromGuild()) {
            return;
        }
        if (args.length < 1) {
            message.getChannel().sendMessage(getHelp()).queue();
        }
        if (NekosFun.isValidTag(args[0].toLowerCase())) {
            if (NekosFun.isTagNSFW(args[0].toLowerCase())) {
                if (!channel.isNSFW()) {
                    message.reply("Please use a NSFW channel for this tag!").queue();
                } else {
                    channel.sendMessage(NekosFun.getImageURL(args[0].toLowerCase())).queue();
                    channel.sendMessage("ENJOY  **(=^ ◡ ^=)**").queue();
                }
            } else {
                channel.sendMessage(NekosFun.getImageURL(args[0].toLowerCase())).queue();
                channel.sendMessage("ENJOY  **(=^ ◡ ^=)**").queue();
            }
        } else {
            channel.sendMessage("Invalid token type .help rstuff to see valid tags").queue();
        }
    }

}
