package commands.impl;

import commands.ICommand;
import game.GameBoard;
import game.GameHandler;
import game.BoardToEmotes;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.MessageReaction.ReactionEmote;

public class game implements ICommand{

    @Override
    public String getName() {
        return "!game";
    }

    @Override
    public String getDescription() {
        return "some board game";
    }

    @Override
    public boolean isAdminCommand() {
        return false;
    }

    @Override
    public void onCommand(String command, String[] args, Message message, User sender, Guild guild) throws Exception {
        GameHandler game = new GameHandler(9, 9, 3);
        
    }
}
