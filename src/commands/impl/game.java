package commands.impl;

import commands.ICommand;
import game.board;
import game.getEmotes;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

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
        board board = new board(9,9);
        Message boardmsg = message.getChannel().sendMessage(board.toString()).complete();
        //WIP
    }
}
