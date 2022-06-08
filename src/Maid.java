import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Maid {
    public static void main(String[] args) throws LoginException {
        JDA MaidBot = JDABuilder.createLight("OTg0MTMzOTQ4Mjk4OTExNzc1.GvJKv-.iSlnlY08uvYMCeW6OF9DHHm2iL6wIwDYTz33_4").build();
        MaidBot.addEventListener(new MaidListener());
    }
}
