package MaidBot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import MaidBot.commands.CommandManager;
import MaidBot.utils.ConfigManager;
import MaidBot.utils.ConfigManager.ConfigData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Maid {

    public static String Prefix;
    public static JDA Bot;
    public static Logger Logger;


    public static void main(String[] args) throws Exception {
        Logger = LoggerFactory.getLogger("[MAID BOT]");
        ConfigData data = ConfigManager.getConfigData();
        Prefix = data.getPrefix();
        Logger.info("MADE BY: FatLinuxUser#5841");
        Logger.info("Login in bot using token: "+ data.getToken());
        JDABuilder builder = JDABuilder.createDefault(data.getToken());
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.enableIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS));
        builder.setStatus(data.getOnlineStatus());
        Bot = builder.build();
        Bot.addEventListener(new MaidListener(new CommandManager()));
    }
}
