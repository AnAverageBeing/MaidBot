package MaidBot.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import net.dv8tion.jda.api.OnlineStatus;

public class ConfigManager {

    private static final String CONFIG_FILE_PATH = "config.txt";
    private static final String TOKEN_PREFIX_SEPARATOR = ":";
    private static final String ONLINE_STATUS_PREFIX = "status:";

    private static ConfigData configData;

    public static ConfigData getConfigData() {
        if (configData == null) {
            loadConfigData();
        }
        return configData;
    }

    private static void loadConfigData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CONFIG_FILE_PATH))) {
            String line;
            String token = null;
            String prefix = null;
            String onlineStatus = null;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    // Ignore empty lines and comments
                    continue;
                }
                if (line.startsWith(ONLINE_STATUS_PREFIX)) {
                    onlineStatus = line.substring(ONLINE_STATUS_PREFIX.length()).trim();
                } else {
                    int separatorIndex = line.indexOf(TOKEN_PREFIX_SEPARATOR);
                    if (separatorIndex == -1) {
                        throw new IllegalArgumentException("Invalid config line: " + line);
                    }
                    String key = line.substring(0, separatorIndex).trim();
                    String value = line.substring(separatorIndex + TOKEN_PREFIX_SEPARATOR.length()).trim();
                    if (key.equalsIgnoreCase("token")) {
                        token = value;
                    } else if (key.equalsIgnoreCase("prefix")) {
                        prefix = value;
                    } else {
                        throw new IllegalArgumentException("Unknown config key: " + key);
                    }
                }
            }
            configData = new ConfigData(token, prefix, onlineStatus);
            validateConfigData(configData);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void validateConfigData(ConfigData configData) {
        if (configData.getToken() == null || configData.getToken().isEmpty()) {
            throw new IllegalArgumentException("Bot token cannot be null or empty");
        }
        if (configData.getPrefix() == null || configData.getPrefix().isEmpty()) {
            throw new IllegalArgumentException("Prefix cannot be null or empty");
        }
    }

    public static class ConfigData {
        private String token;
        private String prefix;
        private String onlineStatus;

        public ConfigData(String token, String prefix, String onlineStatus) {
            this.token = token;
            this.prefix = prefix;
            this.onlineStatus = onlineStatus;
        }

        public String getToken() {
            return token;
        }

        public String getPrefix() {
            return prefix;
        }

        public OnlineStatus getOnlineStatus() {
            if (onlineStatus == null) {
                return OnlineStatus.ONLINE;
            }
            switch (onlineStatus.toLowerCase()) {
                case "online":
                    return OnlineStatus.ONLINE;
                case "idle":
                    return OnlineStatus.IDLE;
                case "dnd":
                    return OnlineStatus.DO_NOT_DISTURB;
                case "invisible":
                    return OnlineStatus.INVISIBLE;
                default:
                    throw new IllegalArgumentException("Invalid online status: " + onlineStatus);
            }
        }
    }
}
