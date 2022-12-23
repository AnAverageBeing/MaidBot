package BOT.commands.impl;

import BOT.Maid;
import BOT.commands.CommandManager;
import BOT.commands.ICommand;
import BOT.utils.HelpEmbed;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

public class help implements ICommand{

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "helps you";
    }

    @Override
    public String getHelp() {
        return "Usage: "+Maid.prefix+"help or "+Maid.prefix+"help {command}";
    }

    @Override
    public boolean isAdminCommand() {
        return false;
    }

    @Override
    public void onCommand(String command, String[] args, Message message, User sender, Guild guild) throws Exception {
        if(args.length < 1){
            message.getChannel().sendMessageEmbeds(HelpEmbed.getEmbedBuilder().build()).queue();
        }  else {
            for (ICommand cmd : CommandManager.getCommands()) {
                if(args[0].equalsIgnoreCase(cmd.getName())){
                    message.getChannel().sendMessage(cmd.getHelp()).queue();
                }
            }
        }     
    }
    
}
