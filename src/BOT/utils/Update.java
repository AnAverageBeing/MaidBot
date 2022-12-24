package BOT.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Update {
    private final static String link = "https://github.com/AnAverageBeing/MaidBot/raw/main/MaidBot.jar";
    public static void updateJAR() {
        try {
           InputStream inputstream = new URL(link).openStream();
           Files.copy(inputstream, Paths.get("MaidBot.jar"), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Process p = Runtime.getRuntime().exec("./run.sh");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
