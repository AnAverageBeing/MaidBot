package BOT.commands.impl;

import BOT.Maid;
import BOT.commands.ICommand;
import BOT.utils.Update;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class update implements ICommand{

	@Override
	public String getName() {
		return "update";
	}

	@Override
	public String getDescription() {
		return "updates the bot jar from github";
	}

	@Override
	public String getHelp() {
		return "Usage: "+Maid.prefix+"update";
	}

	@Override
	public boolean isAdminCommand() {
		return true;
	}

	@Override
	public void onCommand(String command, String[] args, Message message, User sender, TextChannel channel, Guild guild) throws Exception {
		
        if(!guild.getMember(sender).hasPermission(Permission.ADMINISTRATOR)){
			channel.sendMessage("This is Admin only command!");
			return;
		} 
		channel.sendMessage("**UPDATING BOT!**\n**the bot will restart soon.**");
		Update.updateJAR();
	}
    
}
