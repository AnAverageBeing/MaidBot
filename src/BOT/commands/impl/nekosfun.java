package BOT.commands.impl;

import BOT.Maid;
import BOT.commands.ICommand;
import BOT.utils.NekosFun;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

public class nekosfun implements ICommand {

    @Override
    public String getName() {
        return "rimage";
    }

    @Override
    public String getDescription() {
        return "sends random image";
    }

    @Override
    public String getHelp() {
        return "Usage: `" + Maid.prefix + "rimage {tag}`" +
                "\n**Tags:**\n" +
                "NSFW TAGS: ```4k,ass,blowjob,boobs,cum,feet,hentai,spank,gasm,lesbian,lewd,pussy```" + "\n" +
                "SFW TAGS: ```kiss,lick,hug,baka,poke,cry,smug,slap,tickle,pat,laugh,feed,cuddle,wallpapers```";
    }

    @Override
    public boolean isAdminCommand() {
        return false;
    }

    @Override
    public void onCommand(String command, String[] args, Message message, User sender, Guild guild) throws Exception {
        if(!message.isFromGuild()){
            return;
        }
        if (args.length < 1) {
            message.getChannel().sendMessage(getHelp()).queue();
        }
        if (NekosFun.isValidTag(args[0])) {
            if (NekosFun.isTagNSFW(args[0])) {
                if(!message.getTextChannel().isNSFW()){
                    message.reply("Please use a NSFW channel for this tag!").queue();
                }
            } else {
                message.getTextChannel().sendMessage(NekosFun.getImageURL(args[0])).queue();
                message.getTextChannel().sendMessage("ENJOY  **(=^ ◡ ^=)**").queue();
            }
        }
    }

}