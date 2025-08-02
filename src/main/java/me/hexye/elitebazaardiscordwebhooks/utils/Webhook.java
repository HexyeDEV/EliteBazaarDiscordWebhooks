package me.hexye.elitebazaardiscordwebhooks.utils;

import org.bukkit.Bukkit;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Webhook {
    private static int discordColor(String hexColor) {
        if (hexColor == null) {
            return 0x5865F2; // Default Discord blurple
        }

        // Ensure the color string starts with "#"
        if (!hexColor.startsWith("#")) {
            hexColor = "#" + hexColor;
        }

        // Validate format
        if (!hexColor.matches("^#([A-Fa-f0-9]{6})$")) {
            return 0x5865F2;
        }

        // Parse hex into integer
        return Integer.parseInt(hexColor.substring(1), 16);
    }

    public static void sendWebhook(String url, String title, String description, String thumbnailURL, String color, String footer) {
        try{
            URL webhookUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) webhookUrl.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            int colorInt = discordColor(color);

            String json = "{"
                    + "\"embeds\": ["
                    + "{"
                    + "\"title\": \"" + title + "\","
                    + "\"description\": \"" + description + "\","
                    + "\"thumbnail\": {"
                    + "\"url\": \"" + thumbnailURL + "\""
                    + "},"
                    + "\"color\": " + colorInt + ","
                    + "\"footer\": {"
                    + "\"text\": \"" + footer + "\""
                    + "}"
                    + "}"
                    + "]"
                    + "}";

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes(StandardCharsets.UTF_8);
                os.write(input);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode != 204) {
                Bukkit.getLogger().warning("Webhook error: HTTP" + responseCode);
            }
        } catch (Exception e) {
            Bukkit.getLogger().severe("Failed to send webhook: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
