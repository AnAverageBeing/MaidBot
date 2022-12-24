package BOT;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import BOT.utils.GetToken;

import javax.security.auth.login.LoginException;

public class Maid {
    public static String prefix = ".";
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault(GetToken.get());
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.enableIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS));
        JDA BOT = builder.build();
        BOT.addEventListener(new MaidListener());
    }
}
