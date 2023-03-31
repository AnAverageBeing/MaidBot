package MaidBot.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import net.dv8tion.jda.api.OnlineStatus;

public class ConfigManager {

    private static final Path CONFIG_FILE_PATH = Path.of("config.txt");
    private static final String TOKEN_KEY = "token";
    private static final String PREFIX_KEY = "prefix";
    private static final String ONLINE_STATUS_KEY = "status";
    private static final String ONLINE_STATUS_DEFAULT = "online";

    private static ConfigData configData;

    public static ConfigData getConfigData() {
        if (configData == null) {
            loadConfigData();
        }
        return configData;
    }

    private static void loadConfigData() {
        try {
            Map<String, String> configMap = Files.lines(CONFIG_FILE_PATH)
                    .map(String::trim)
                    .filter(line -> !line.isEmpty() && !line.startsWith("#"))
                    .map(line -> line.split(":", 2))
                    .collect(Collectors.toMap(arr -> arr[0].trim(), arr -> arr[1].trim()));

            String token = configMap.get(TOKEN_KEY).equalsIgnoreCase("token-goes-here") ? System.getenv("TOKEN") : configMap.get(TOKEN_KEY);
            String prefix = configMap.get(PREFIX_KEY);
            String onlineStatus = configMap.getOrDefault(ONLINE_STATUS_KEY, ONLINE_STATUS_DEFAULT);

            Objects.requireNonNull(token, "Bot token cannot be null or empty");
            Objects.requireNonNull(prefix, "Prefix cannot be null or empty");

            configData = new ConfigData(token, prefix, onlineStatus);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void validateConfigData(ConfigData configData) {
        Objects.requireNonNull(configData.getToken(), "Bot token cannot be null or empty");
        Objects.requireNonNull(configData.getPrefix(), "Prefix cannot be null or empty");
    }

    public static class ConfigData {
        private final String token;
        private final String prefix;
        private final OnlineStatus onlineStatus;

        public ConfigData(String token, String prefix, String onlineStatus) {
            this.token = token;
            this.prefix = prefix;
            this.onlineStatus = OnlineStatus.valueOf(onlineStatus.toUpperCase());
            validateConfigData(this);
        }

        public String getToken() {
            return token;
        }

        public String getPrefix() {
            return prefix;
        }

        public OnlineStatus getOnlineStatus() {
            return onlineStatus;
        }
    }
}
