package MaidBot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import MaidBot.commands.CommandManager;
import MaidBot.listners.MaidListener;
import MaidBot.utils.ConfigManager;
import MaidBot.utils.ConfigManager.ConfigData;

public class Maid {

    public static String Prefix;
    public static JDA Bot;


    public static void main(String[] args) throws Exception {
        ConfigData data = ConfigManager.getConfigData();
        Prefix = data.getPrefix();
        System.out.println("MADE BY: FatLinuxUser#5841");
        System.out.println("Login in bot using token: "+ data.getToken());
        JDABuilder builder = JDABuilder.createDefault(data.getToken());
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.enableIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS));
        builder.setStatus(data.getOnlineStatus());
        Bot = builder.build();
        Bot.addEventListener(new MaidListener(new CommandManager()));
    }
}
