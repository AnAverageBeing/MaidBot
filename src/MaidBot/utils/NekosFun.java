package MaidBot.utils;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NekosFun {
    private static final String API_BASE_URL = "http://api.nekos.fun:8080/api/";
    private static final List<String> SFW_TAGS = Collections.unmodifiableList(
            Arrays.asList("kiss", "lick", "hug", "baka", "poke", "cry", "smug", "slap", "tickle", "pat", "laugh", "feed",
                    "cuddle", "wallpapers"));
    private static final List<String> NSFW_TAGS = Collections.unmodifiableList(
            Arrays.asList("4k", "blowjob", "boobs", "cum", "feet", "hentai", "spank", "gasm", "lesbian", "lewd", "pussy"));

    public static String getImageURL(String tag) throws IOException {
        if (!isValidTag(tag)) {
            throw new IllegalArgumentException("Invalid tag");
        }

        URL url = new URL(API_BASE_URL + tag);
        try (Scanner scanner = new Scanner(url.openStream())) {
            StringBuilder response = new StringBuilder();
            while (scanner.hasNext()) {
                response.append(scanner.next());
            }
            return response.toString().split("\"")[3];
        }
    }

    public static boolean isValidTag(String tag) {
        return SFW_TAGS.contains(tag.toLowerCase()) || NSFW_TAGS.contains(tag.toLowerCase());
    }

    public static boolean isTagNSFW(String tag) {
        return NSFW_TAGS.contains(tag.toLowerCase());
    }

    public static List<String> getSfwTags() {
        return SFW_TAGS;
    }

    public static List<String> getNsfwTags() {
        return NSFW_TAGS;
    }
}
