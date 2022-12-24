package BOT.utils;

import java.net.URL;
import java.util.Scanner;

public class NekosFun {
    private static String api = "http://api.nekos.fun:8080/api/";
    private static String[] sfwTags = { "kiss", "lick", "hug", "baka", "poke", "cry", "smug", "slap", "tickle", "pat",
            "laugh", "feed", "cuddle", "wallpapers" };
    private static String[] nsfwTags = { "4k", "blowjob", "boobs", "cum", "feet", "hentai", "spank", "gasm",
            "lesbian", "lewd", "pussy" };

    public static String getImageURL(String tag) {
        String result = "";
        try {
            URL link = new URL(api + tag);
            Scanner sc = new Scanner(link.openStream());
            StringBuffer sb = new StringBuffer();
            while (sc.hasNext()) {
                sb.append(sc.next());
            }
            result = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.split("\"")[3];
    }

    public static boolean isValidTag(String tag) {
        for (String string : nsfwTags) {
            if (tag.toLowerCase().equals(string)) {
                return true;
            }
        }

        for (String string : sfwTags) {
            if (tag.toLowerCase().equals(string)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isTagNSFW(String tag) {
        for (String string : nsfwTags) {
            if (tag.toLowerCase().equals(string)) {
                return true;
            }
        }

        return false;
    }

}
