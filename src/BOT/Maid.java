package BOT;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import BOT.utils.GetToken;

import javax.security.auth.login.LoginException;

public class Maid {
    public static String prefix = ".";
    public static void main(String[] args) throws LoginException {
        JDA MaidBOT = JDABuilder.createLight(GetToken.get()).build();
        MaidBOT.addEventListener(new MaidListener());
    }
}
