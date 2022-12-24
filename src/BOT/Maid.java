package BOT;

import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import BOT.utils.GetToken;

import javax.security.auth.login.LoginException;

public class Maid {
    public static String prefix = ".";
    private static ShardManager manager;
    public static void main(String[] args) throws LoginException {
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(GetToken.get());
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.enableIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS));
        manager = builder.build();
        manager.addEventListener(new MaidListener());
    }
}
