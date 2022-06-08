import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Maid {
    public static void main(String[] args) throws LoginException {
        JDA MaidBot = JDABuilder.createLight("OTg0MTMzOTQ4Mjk4OTExNzc1.Gicdpu.wkCvulbWPa77BXEgfWxlBToRq29aqmbgGkGicA").build();
        MaidBot.addEventListener(new MaidListener());
    }
}