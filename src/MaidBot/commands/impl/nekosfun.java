package MaidBot.commands.impl;

import MaidBot.Maid;
import MaidBot.commands.ICommand;
import MaidBot.utils.NekosFun;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class nekosfun implements ICommand {

    private static final int TAG_LIMIT = 10;

    @Override
    public String getName() {
        return "nekosfun";
    }

    @Override
    public String getDescription() {
        return "Sends random anime image or gifs for a given tag";
    }

    @Override
    public String getHelp() {
        List<String> nsfwTags = NekosFun.getNsfwTags();
        List<String> sfwTags = NekosFun.getSfwTags();

        return String.format("Usage: `%snekosfun {tag(s)}`\n\n**Tags:**\n\n" +
                "NSFW TAGS: `%s`\nSFW TAGS: `%s`",
                Maid.Prefix, String.join(",", nsfwTags), String.join(",", sfwTags));
    }

    @Override
    public boolean isAdminCommand() {
        return false;
    }

    @Override
    public void onCommand(String command, String[] args, Message message, User sender, TextChannel channel, Guild guild) {
        if (!message.isFromGuild()) {
            return;
        }

        if (args.length == 0) {
            message.getChannel().sendMessage(getHelp()).queue();
            return;
        }

        List<String> tags = Arrays.stream(args)
                .limit(TAG_LIMIT)
                .map(String::toLowerCase)
                .filter(NekosFun::isValidTag)
                .collect(Collectors.toList());

        if (tags.isEmpty()) {
            channel.sendMessage("Invalid tag. Use `" + Maid.Prefix + "help nekosfun` to see valid tags.").queue();
            return;
        }

        for (String tag : tags) {
            if (NekosFun.isTagNSFW(tag) && !channel.isNSFW()) {
                channel.sendMessage("Please use a NSFW channel for the NSFW tag '" + tag + "'!").queue();
            } else {
                try {
                    channel.sendMessage(NekosFun.getImageURL(tag)).queue();
                } catch (IOException e) {
                    channel.sendMessage("```\n"+e.getMessage()+"\n```").queue();
                }
            }
        }
        channel.sendMessage("Enjoy! (=^ ◡ ^=)").queue();
    }

}
