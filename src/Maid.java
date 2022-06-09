import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Maid {
    public static void main(String[] args) throws LoginException {
<<<<<<< HEAD
        JDA MaidBot = JDABuilder.createLight(System.getenv("token")).build();
=======
        JDA MaidBot = JDABuilder.createLight("Token Here").build();
>>>>>>> d18b0a1fdf2ce07e31b0d1cbbd421c021f5f3d87
        MaidBot.addEventListener(new MaidListener());
    }
}
